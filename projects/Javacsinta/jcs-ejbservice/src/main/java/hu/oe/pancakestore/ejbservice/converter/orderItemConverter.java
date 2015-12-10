package hu.oe.pancakestore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.serviceclient.domain.orderItemStub;
import hu.oe.pancakestore.serviceclient.domain.orderDetailStub;
import hu.oe.pancakestore.persistence.entity.orderItem;
import hu.oe.pancakestore.persistence.result.orderDetailResult;




@Local
public interface orderItemConverter {

	orderItemStub to(orderItem orderItems);

	//List<orderItemStub> to(List<orderItem> orderItems);

	List<orderDetailStub> to(List<orderDetailResult> orderDetails);

}
