package hu.oe.pancakestore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.ejbservice.domain.OrderHeaderStub;
import hu.oe.pancakestore.persistence.entity.OrderHeader;




@Local
public interface OrderHeaderConverter {

	OrderHeaderStub to(OrderHeader OrderHeader);

	List<OrderHeaderStub> to(List<OrderHeader> OrderHeaders);

}
