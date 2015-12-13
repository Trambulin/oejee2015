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

import hu.oe.pancakestore.persistence.entity.OrderItem;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.parameter.orderDetailParameter;
import hu.oe.pancakestore.persistence.parameter.orderItemParameter;
import hu.oe.pancakestore.persistence.query.orderItemQuery;
import hu.oe.pancakestore.persistence.query.orderDetailQuery;
import hu.oe.pancakestore.persistence.result.orderDetailResult;


@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class orderItemServiceImpl implements orderItemService{

	
	private static final Logger LOGGER = Logger.getLogger(orderItemServiceImpl.class);

	@PersistenceContext(unitName = "jcs-persistence-unit")
	private EntityManager entityManager;
	
	
	/*@EJB
	private StudentService studentService;

	@EJB
	private SubjectService subjectService;
	*/
	
	@Override
	public List<orderDetailResult> read(Long customerId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get all orderDetailResult by customer id (" + customerId + ")");
		}
		List<orderDetailResult> result = null;
		try {
			result = this.entityManager.createNamedQuery(orderDetailQuery.GET_SUM_orderDetail, orderDetailResult.class)
					.setParameter(orderDetailParameter.CUSTOMER_ID, customerId).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customers! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<OrderItem> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Order Details");
		}
		List<OrderItem> result = null;
		try {
			result = this.entityManager.createNamedQuery(orderItemQuery.GET_ALL, OrderItem.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Order Details! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public int count(Long pancakeId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Count  pancakes in orders by pancake's id (" + pancakeId + ")");
		}
		try {
			return this.entityManager.createNamedQuery(orderItemQuery.GET_COUNT_PANCAKES_BY_ID, Long.class).setParameter(orderItemParameter.PANCAKE_ID, pancakeId)
					.getSingleResult().intValue();
		} catch (final Exception e) {
			throw new PersistenceServiceException(
					"Unknown error during counting pancakes in orders (" + pancakeId + ")! " + e.getLocalizedMessage(), e);
		}
	}

}
