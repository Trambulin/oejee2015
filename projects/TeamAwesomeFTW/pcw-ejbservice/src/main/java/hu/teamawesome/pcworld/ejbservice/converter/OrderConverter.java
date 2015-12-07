package hu.teamawesome.pcworld.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.teamawesome.pcworld.ejbservice.domain.OrderStub;
import hu.teamawesome.pcworld.persistence.entity.Order;

@Local
public interface OrderConverter {

	OrderStub to(Order order);

	List<OrderStub> to(List<Order> orders);

}
