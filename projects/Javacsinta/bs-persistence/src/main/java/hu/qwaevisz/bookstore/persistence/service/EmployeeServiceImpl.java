package hu.qwaevisz.bookstore.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.qwaevisz.bookstore.persistence.entity.Employee;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.bookstore.persistence.parameter.CustomerParameter;
import hu.qwaevisz.bookstore.persistence.parameter.EmployeeParameter;
import hu.qwaevisz.bookstore.persistence.query.EmployeeQuery;


@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class);

	@PersistenceContext(unitName = "bs-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Employee read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customer by id (" + id + ")");
		}
		Employee result = null;
		try {
			result = this.entityManager.createNamedQuery(EmployeeQuery.GET_BY_ID, Employee.class).setParameter(EmployeeParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Employee by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Employee read(String name) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customer by NAME (" + name + ")");
		}
		Employee result = null;
		try {
			result = this.entityManager.createNamedQuery(EmployeeQuery.GET_BY_NAME, Employee.class).setParameter(CustomerParameter.NAME, name).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customer by NAME (" + name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Employee> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Customers");
		}
		List<Employee> result = null;
		try {
			result = this.entityManager.createNamedQuery(EmployeeQuery.GET_ALL, Employee.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customers! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
