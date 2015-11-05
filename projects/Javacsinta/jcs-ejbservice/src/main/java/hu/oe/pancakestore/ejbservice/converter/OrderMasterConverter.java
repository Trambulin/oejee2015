package hu.oe.pancakestore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.ejbservice.domain.OrderMasterStub;
import hu.oe.pancakestore.persistence.entity.OrderMaster;




@Local
public interface OrderMasterConverter {

	OrderMasterStub to(OrderMaster orderMaster);

	List<OrderMasterStub> to(List<OrderMaster> orderMasters);

}
