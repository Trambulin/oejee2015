package hu.oe.pancakestore.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.oe.pancakestore.ejbservice.domain.DeliveryStatusStub;
import hu.oe.pancakestore.ejbservice.domain.OrderMasterStub;
import hu.oe.pancakestore.persistence.entity.OrderDetail;
import hu.oe.pancakestore.persistence.entity.OrderMaster;


@Stateless
public class OrderMasterConverterImpl implements OrderMasterConverter {

@EJB
private CustomerConverter customerconverter;

@EJB
private EmployeeConverter employeeconverter;

@EJB
private OrderDetailConverter orderdetailconverter;

	
	@Override
	public OrderMasterStub to(OrderMaster orderMaster) {
		final DeliveryStatusStub deliverystatus = DeliveryStatusStub.valueOf(orderMaster.getDeliverytStatus().toString());
		final OrderMasterStub ordermasterstub= new OrderMasterStub(this.customerconverter.to(orderMaster.getCustomer()),this.employeeconverter.to(orderMaster.getEmployee()),deliverystatus,orderMaster.getTotal_price());
		
		for (final OrderDetail orderDetail : orderMaster.getOrderDetails()) {
			ordermasterstub.addOrderDetails(this.orderdetailconverter.to(orderDetail));
		}
		
		return ordermasterstub;
	}

	@Override
	public List<OrderMasterStub> to(List<OrderMaster> orderMasters) {
		final List<OrderMasterStub> result = new ArrayList<>();
		for (final OrderMaster orderMaster : orderMasters) {
			result.add(this.to(orderMaster));
		}
		return result;
	}

}
