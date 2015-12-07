package hu.teamawesome.pcworld.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.persistence.entity.Customer;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;
import hu.teamawesome.pcworld.persistence.parameter.CustomerParameter;
import hu.teamawesome.pcworld.persistence.query.CustomerQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

	@PersistenceContext(unitName = "pcw-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Customer read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get product by id (" + id + ")");
		}
		Customer result = null;
		try {
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_BY_ID, Customer.class).setParameter(CustomerParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Product by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

		@Override
	public List<Customer> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Books");
		}
		List<Customer> result = null;
		try {
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_ALL, Customer.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Books! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
}