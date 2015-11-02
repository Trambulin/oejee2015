package hu.qwaevisz.bookstore.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import hu.qwaevisz.bookstore.ejbservice.domain.OrderDetailStub;
import hu.qwaevisz.bookstore.persistence.entity.OrderDetail;

@Stateless

public class OrderDetailConverterImpl implements OrderDetailConverter {


@EJB
private PancakeConverter pancakeconverter;
	
	@Override
	public OrderDetailStub to(OrderDetail orderDetails) {
		return new OrderDetailStub(this.pancakeconverter.to(orderDetails.getPancake()),orderDetails.getAmount(),orderDetails.getTotal_price());
	}

	@Override
	public List<OrderDetailStub> to(List<OrderDetail> orderDetails) {
		final List<OrderDetailStub> result = new ArrayList<>();
		for (final OrderDetail orderdetail : orderDetails) {
			result.add(this.to(orderdetail));
		}
		return result;
	}

}
