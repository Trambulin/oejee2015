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


import hu.qwaevisz.bookstore.persistence.entity.OrderDetail;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.bookstore.persistence.parameter.OrderDetailParameter;
import hu.qwaevisz.bookstore.persistence.query.OrderDetailQuery;


@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class OrderDetailServiceImpl implements OrderDetailService{

	
	private static final Logger LOGGER = Logger.getLogger(OrderDetailServiceImpl.class);

	@PersistenceContext(unitName = "bs-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public OrderDetail read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Order Detail by id (" + id + ")");
		}
		OrderDetail result = null;
		try {
			result = this.entityManager.createNamedQuery(OrderDetailQuery.GET_BY_ID, OrderDetail.class).setParameter(OrderDetailParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Order Detail by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<OrderDetail> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Order Details");
		}
		List<OrderDetail> result = null;
		try {
			result = this.entityManager.createNamedQuery(OrderDetailQuery.GET_ALL, OrderDetail.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Order Details! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
