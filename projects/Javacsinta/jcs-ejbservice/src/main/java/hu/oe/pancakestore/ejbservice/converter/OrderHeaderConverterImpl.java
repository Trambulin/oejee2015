package hu.oe.pancakestore.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.oe.pancakestore.serviceclient.domain.DeliveryStatusStub;
import hu.oe.pancakestore.serviceclient.domain.OrderHeaderStub;
import hu.oe.pancakestore.serviceclient.domain.PaymentMethodStub;
import hu.oe.pancakestore.persistence.entity.orderItem;
import hu.oe.pancakestore.persistence.entity.OrderHeader;


@Stateless
public class OrderHeaderConverterImpl implements OrderHeaderConverter {

@EJB
private CustomerConverter customerconverter;

@EJB
private EmployeeConverter employeeconverter;

@EJB
private orderItemConverter orderItemconverter;

	
	@Override
	public OrderHeaderStub to(OrderHeader OrderHeader) {
		final DeliveryStatusStub deliverystatus = DeliveryStatusStub.valueOf(OrderHeader.getDeliverytStatus().toString());
		final PaymentMethodStub paymentmethod = PaymentMethodStub.valueOf(OrderHeader.getPaymentMethod().toString());
		final OrderHeaderStub OrderHeaderstub= new OrderHeaderStub(this.customerconverter.to(OrderHeader.getCustomer()),this.employeeconverter.to(OrderHeader.getEmployee()),deliverystatus,OrderHeader.getTotal_price(),OrderHeader.getDate(),paymentmethod);
		
		for (final orderItem orderItem : OrderHeader.getorderItems()) {
			OrderHeaderstub.addorderItems(this.orderItemconverter.to(orderItem));
		}
		
		return OrderHeaderstub;
	}

	@Override
	public List<OrderHeaderStub> to(List<OrderHeader> OrderHeaders) {
		final List<OrderHeaderStub> result = new ArrayList<>();
		for (final OrderHeader OrderHeader : OrderHeaders) {
			result.add(this.to(OrderHeader));
		}
		return result;
	}

}
