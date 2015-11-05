package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.persistence.entity.Employee;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.parameter.CustomerParameter;
import hu.oe.pancakestore.persistence.parameter.EmployeeParameter;
import hu.oe.pancakestore.persistence.query.EmployeeQuery;


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
			LOGGER.debug("Get Employee by id (" + id + ")");
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
			LOGGER.debug("Get Employee by NAME (" + name + ")");
		}
		Employee result = null;
		try {
			result = this.entityManager.createNamedQuery(EmployeeQuery.GET_BY_NAME, Employee.class).setParameter(CustomerParameter.NAME, name).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Employee by NAME (" + name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Employee> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Employess");
		}
		List<Employee> result = null;
		try {
			result = this.entityManager.createNamedQuery(EmployeeQuery.GET_ALL, Employee.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Employees! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
