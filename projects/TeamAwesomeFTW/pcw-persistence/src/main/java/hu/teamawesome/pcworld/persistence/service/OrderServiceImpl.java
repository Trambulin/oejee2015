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

import hu.teamawesome.pcworld.persistence.entity.Order;
import hu.teamawesome.pcworld.persistence.exception.PersistenceServiceException;
import hu.teamawesome.pcworld.persistence.parameter.OrderParameter;
import hu.teamawesome.pcworld.persistence.query.OrderQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class OrderServiceImpl implements OrderService {

	private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

	@PersistenceContext(unitName = "pcw-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Order read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get product by id (" + id + ")");
		}
		Order result = null;
		try {
			result = this.entityManager.createNamedQuery(OrderQuery.GET_BY_ID, Order.class).setParameter(OrderParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Product by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

		@Override
	public List<Order> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Books");
		}
		List<Order> result = null;
		try {
			result = this.entityManager.createNamedQuery(OrderQuery.GET_ALL, Order.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Books! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
}