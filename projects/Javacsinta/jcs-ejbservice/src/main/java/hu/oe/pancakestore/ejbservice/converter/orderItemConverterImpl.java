package hu.oe.pancakestore.ejbservice.converter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import hu.oe.pancakestore.ejbservice.domain.orderItemStub;
import hu.oe.pancakestore.ejbservice.domain.orderDetailStub;
import hu.oe.pancakestore.persistence.entity.orderItem;
import hu.oe.pancakestore.persistence.result.orderDetailResult;

@Stateless

public class orderItemConverterImpl implements orderItemConverter {


@EJB
private PancakeConverter pancakeconverter;
	
	@Override
	public orderItemStub to(orderItem orderItems) {
		return new orderItemStub(this.pancakeconverter.to(orderItems.getPancake()),orderItems.getAmount(),orderItems.getTotal_price());
	}

	@Override
	public List<orderDetailStub> to(List<orderDetailResult> orderDetails) {
		final List<orderDetailStub> result = new ArrayList<>();
		for (final orderDetailResult orderDetail : orderDetails) {
			result.add(this.to(orderDetail));
		}
		return result;
	}

	//this.addressconverter.to(customer.getAddress())
	private orderDetailStub to(final orderDetailResult result) {
		return new orderDetailStub(this.pancakeconverter.to(result.getPancake()), this.getMonthFromDate(result.getMonth()), result.getSumAmount());
	}

	private int getMonthFromDate(Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

}
