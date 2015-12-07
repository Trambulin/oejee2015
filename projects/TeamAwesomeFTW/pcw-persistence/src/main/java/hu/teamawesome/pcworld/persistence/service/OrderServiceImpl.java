package hu.teamawesome.pcworld.persistence.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.persistence.entity.Order;
import hu.teamawesome.pcworld.persistence.entity.Storage;
import hu.teamawesome.pcworld.persistence.entity.Supplier;
import hu.teamawesome.pcworld.persistence.entity.Customer;
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
	
	@EJB
	private SupplierService supplierService;
	
	@EJB
	private StorageService storageService;

	@EJB
	private CustomerService customerService;
	
	@EJB
	private OrderService orderService;
	

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
	
	@Override
	public Order create(Long cid, Long pid) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add Order (customerID: " + cid + ", supplier productID: " + pid + ")");
		}
		try {
			Storage storage = this.storageService.read(pid);
			Customer customer = this.customerService.read(cid);
			
			
			int quantity = storage.getQuantity();
			int reserved = storage.getQuantityReserved();
			int price = storage.getPrice();
			
			int available = quantity - reserved;
			Date dNow = new Date();
			Date dDue = dNow;
			
			if (available > 0)
			{
				// Helyi készletből veszi. Ettől persze még a rendelést megcsinálja. ShipmentDue értelemszerűen instant.
				storage.setQuantityReserved(reserved + 1);
			}
			else
			{
				// Rendel beszállítótól.
				storage.setQuantity(quantity + 1);
				storage.setQuantityReserved(reserved + 1);
				
				
				// A ShipmentDue az x nap múlva esedékes.
				Calendar c = Calendar.getInstance(); 
				c.setTime(dDue); 
				c.add(Calendar.DATE, storage.getSupplier().getShippingDays());
				dDue = c.getTime();
			}
			
			
			Order order = new Order(storage.getSupplier(), customer, price, dNow, dDue);	
			
			
			storage = this.entityManager.merge(storage);
			order = this.entityManager.merge(order);
			this.entityManager.flush();
			return order;
			
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during merging SubscriberGroup (cid: " + cid + ", pid: " + pid + ")! " + e.getLocalizedMessage(), e);
		}
	}
	
	@Override
	public Order setDelivered(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Set Order to delivered (id: " + id + ")");
		}
		try {
			Order order = this.orderService.read(id);	
			Storage storage = this.storageService.read(order.getSupplier().getId()); // storage saját ID-jét sehol nem használjuk, mindig a SupplierID alapján kérdezi le.
			
			// update storage
			storage.setQuantity(storage.getQuantity() - 1);
			storage.setQuantityReserved(storage.getQuantityReserved() - 1);
			
			// archive order
			order.setDelivered(true);
			
			
			// Flush
			storage = this.entityManager.merge(storage);
			order = this.entityManager.merge(order);
			this.entityManager.flush();
			return order;
			
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during merging SubscriberGroup (id: " + id + ")! " + e.getLocalizedMessage(), e);
		}
	}
}