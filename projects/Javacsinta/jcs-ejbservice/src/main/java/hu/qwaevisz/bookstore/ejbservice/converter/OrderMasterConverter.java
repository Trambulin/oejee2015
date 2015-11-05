package hu.qwaevisz.bookstore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.ejbservice.domain.OrderMasterStub;
import hu.qwaevisz.bookstore.persistence.entity.OrderMaster;




@Local
public interface OrderMasterConverter {

	OrderMasterStub to(OrderMaster orderMaster);

	List<OrderMasterStub> to(List<OrderMaster> orderMasters);

}
