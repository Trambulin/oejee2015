package hu.oe.pancakestore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.serviceclient.domain.orderItemStub;
import hu.oe.pancakestore.serviceclient.domain.orderDetailStub;
import hu.oe.pancakestore.persistence.entity.OrderItem;
import hu.oe.pancakestore.persistence.result.orderDetailResult;




@Local
public interface orderItemConverter {

	orderItemStub to(OrderItem OrderItems);

	//List<orderItemStub> to(List<OrderItem> orderItems);

	List<orderDetailStub> to(List<orderDetailResult> orderDetails);

}
