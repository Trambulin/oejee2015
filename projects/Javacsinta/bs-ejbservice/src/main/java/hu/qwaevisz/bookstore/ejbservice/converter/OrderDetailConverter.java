package hu.qwaevisz.bookstore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.ejbservice.domain.OrderDetailStub;
import hu.qwaevisz.bookstore.persistence.entity.OrderDetail;




@Local
public interface OrderDetailConverter {

	OrderDetailStub to(OrderDetail orderDetails);

	List<OrderDetailStub> to(List<OrderDetail> orderDetails);

}
