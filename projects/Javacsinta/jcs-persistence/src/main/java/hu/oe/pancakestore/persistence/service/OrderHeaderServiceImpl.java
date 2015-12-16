package hu.oe.pancakestore.persistence.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.persistence.entity.Customer;
import hu.oe.pancakestore.persistence.entity.Employee;
import hu.oe.pancakestore.persistence.entity.OrderHeader;
import hu.oe.pancakestore.persistence.entity.OrderItem;
import hu.oe.pancakestore.persistence.entity.trunk.DeliveryStatus;
import hu.oe.pancakestore.persistence.entity.trunk.PaymentMethod;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.parameter.OrderHeaderParameter;
import hu.oe.pancakestore.persistence.query.OrderHeaderQuery;


@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class OrderHeaderServiceImpl implements OrderHeaderService{

	
	private static final Logger LOGGER = Logger.getLogger(OrderHeaderServiceImpl.class);

	@PersistenceContext(unitName = "jcs-persistence-unit")
	private EntityManager entityManager;
	
	@EJB
	CustomerService customerService;
	
	@EJB
	EmployeeService employeeService;
	
	
	@Override
	public OrderHeader read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get order_header by id (" + id + ")");
		}
		OrderHeader result = null;
		try {
			result = this.entityManager.createNamedQuery(OrderHeaderQuery.GET_BY_ID, OrderHeader.class).setParameter(OrderHeaderParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching order_header by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<OrderHeader> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get order_headers");
		}
		List<OrderHeader> result = null;
		try {
			result = this.entityManager.createNamedQuery(OrderHeaderQuery.GET_ALL, OrderHeader.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching OrderHeaders! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public void create(Long customerId, Long employeeId, Set<OrderItem> orderitems,
			DeliveryStatus deliveryStatus, Float totalPrice, Date date, PaymentMethod paymentMethod)
					throws PersistenceServiceException {
		try {
			
			final Customer customer = this.customerService.read(customerId);
			final Employee employee = this.employeeService.read(employeeId);
			OrderHeader orderHeader = new OrderHeader(customer,employee,orderitems,deliveryStatus,totalPrice,date,paymentMethod);
			orderHeader = this.entityManager.merge(orderHeader);
			this.entityManager.flush();
		
		} catch (Exception e) {
			throw new PersistenceServiceException("Unknown error during merging SubscriberGroup (customerId: " + customerId + ", employeeId: " + employeeId
					+ ", orderitems: " + orderitems + ", DeliveryStatus: " + deliveryStatus +  ", TotalPrice: " + totalPrice +   ", Date: " + date+  ", PaymentMethod: " + paymentMethod+")! " + e.getLocalizedMessage(), e);
		}
		
	}

}
