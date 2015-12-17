package hu.oe.pancakestore.ejbservice.facade;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.ejbservice.converter.OrderHeaderConverter;
import hu.oe.pancakestore.ejbservice.holder.PancakeStateHolder;
import hu.oe.pancakestore.serviceclient.domain.OrderHeaderStub;
import hu.oe.pancakestore.serviceclient.domain.OrderItemStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;
import hu.oe.pancakestore.serviceclient.util.ApplicationError;
import hu.oe.pancakestore.persistence.entity.OrderItem;
import hu.oe.pancakestore.persistence.entity.Pancake;
import hu.oe.pancakestore.persistence.entity.trunk.DeliveryStatus;
import hu.oe.pancakestore.persistence.entity.trunk.PaymentMethod;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;
import hu.oe.pancakestore.persistence.service.CustomerService;
import hu.oe.pancakestore.persistence.service.EmployeeService;
import hu.oe.pancakestore.persistence.service.OrderHeaderService;
import hu.oe.pancakestore.persistence.service.PancakeService;


@Stateless(mappedName = "ejb/OrderHeaderFacade")
public class OrderHeaderFacadeImpl implements OrderHeaderFacade{

	private static final Logger LOGGER = Logger.getLogger(OrderHeaderFacadeImpl.class);
	
	
	@EJB
	private PancakeStateHolder stateHolder;
	
	@EJB
	private OrderHeaderService service;
	
	@EJB
	private CustomerService customerService;
	
	@EJB
	private EmployeeService employeeService;

	@EJB
	private OrderHeaderConverter converter;
	
	@EJB
	private PancakeService pancakeService;
	
	
	@Override
	public OrderHeaderStub getOrderHeader(Long id) throws FacadeException {
		try {
			final OrderHeaderStub stub = this.converter.to(this.service.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get OrderHeader by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<OrderHeaderStub> getOrderHeaders() throws FacadeException {
		List<OrderHeaderStub> stubs = new ArrayList<>();
		try {
		stubs = this.converter.to(this.service.readAll());
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get OrderHeaders:  "  + stubs.size());
		}
	} catch (final PersistenceServiceException e) {
		LOGGER.error(e, e);
		throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
	}
		return stubs;
		
	
	}
	
	@Override
	public void CreateNewOrder(OrderHeaderStub orderheaderstub) throws FacadeException {
		
		try {
			orderheaderstub.setTotalPrice(orderheaderstub.getTotalPrice()*(1-stateHolder.getCurrentReduction()/100.0f));
			
			final Long customerId = this.customerService.readbyEmail(orderheaderstub.getCustomer().getEmail()).getId();
			final Long employeeId = this.employeeService.readbyPhone(orderheaderstub.getEmployee().getPhone()).getId();
		
			Set<OrderItem> orderitems = new HashSet<>();
			for (final OrderItemStub orderitemstub : orderheaderstub.getorderItems()) {
				orderitems.add(new OrderItem(new Pancake(this.pancakeService.read(orderitemstub.getPancake().getName()).getId(),orderitemstub.getPancake().getName(),orderitemstub.getPancake().getPrice(),orderitemstub.getPancake().getDescription()),orderitemstub.getAmount(),orderitemstub.getTotalPrice()));
			}
			
			service.create(customerId,employeeId,orderitems,DeliveryStatus.InProgress,orderheaderstub.getTotalPrice(),orderheaderstub.getDate(),PaymentMethod.CARD);
			
		} catch (PersistenceServiceException e) {
		LOGGER.error(e, e);
		throw new FacadeException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
	}
		
	}

}
