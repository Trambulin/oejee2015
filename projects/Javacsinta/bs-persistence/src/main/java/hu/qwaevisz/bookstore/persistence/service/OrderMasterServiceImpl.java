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


import hu.qwaevisz.bookstore.persistence.entity.OrderMaster;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.bookstore.persistence.parameter.OrderMasterParameter;
import hu.qwaevisz.bookstore.persistence.query.OrderMasterQuery;


@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class OrderMasterServiceImpl implements OrderMasterService{

	
	private static final Logger LOGGER = Logger.getLogger(OrderMasterServiceImpl.class);

	@PersistenceContext(unitName = "bs-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public OrderMaster read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Order_Master by id (" + id + ")");
		}
		OrderMaster result = null;
		try {
			result = this.entityManager.createNamedQuery(OrderMasterQuery.GET_BY_ID, OrderMaster.class).setParameter(OrderMasterParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Order_Master by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<OrderMaster> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Order_Masters");
		}
		List<OrderMaster> result = null;
		try {
			result = this.entityManager.createNamedQuery(OrderMasterQuery.GET_ALL, OrderMaster.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching OrderMasters! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
