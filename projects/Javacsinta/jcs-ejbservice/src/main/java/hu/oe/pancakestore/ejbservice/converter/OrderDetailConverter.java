package hu.oe.pancakestore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.ejbservice.domain.OrderDetailStub;
import hu.oe.pancakestore.persistence.entity.OrderDetail;




@Local
public interface OrderDetailConverter {

	OrderDetailStub to(OrderDetail orderDetails);

	List<OrderDetailStub> to(List<OrderDetail> orderDetails);

}
