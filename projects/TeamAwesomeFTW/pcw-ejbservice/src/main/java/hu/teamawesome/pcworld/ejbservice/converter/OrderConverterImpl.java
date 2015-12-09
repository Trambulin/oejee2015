package hu.teamawesome.pcworld.ejbservice.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import hu.teamawesome.pcworld.ejbservice.domain.OrderStub;
import hu.teamawesome.pcworld.persistence.entity.Order;
import hu.teamawesome.pcworld.ejbservice.domain.CustomerStub;
import hu.teamawesome.pcworld.ejbservice.domain.ManufacturerStub;
import hu.teamawesome.pcworld.persistence.entity.Customer;
import hu.teamawesome.pcworld.persistence.entity.Manufacturer;
import hu.teamawesome.pcworld.persistence.entity.Supplier;
import hu.teamawesome.pcworld.persistence.entity.Type;
import hu.teamawesome.pcworld.ejbservice.domain.SupplierStub;
import hu.teamawesome.pcworld.ejbservice.domain.TypeStub;


@Stateless
public class OrderConverterImpl implements OrderConverter {

	@Override
	public OrderStub to(Order order)
	{
		final Customer cm = order.getCustomer(); 
		final Supplier sup = order.getSupplier();
		final Manufacturer mf = sup.getManufacturer();
		final Type tp = sup.getType();
		
		// Manufacturer
		final ManufacturerStub manufacturerStub = new ManufacturerStub(mf.getName(), mf.getTelephone());
		
		// Type
		final TypeStub typeStub = new TypeStub(tp.getId(), tp.getName());
		
		// Supplier
		final SupplierStub supplierStub = new SupplierStub(sup.getId(), typeStub, sup.getName(), sup.getDescription(),
				sup.getWarranty(), sup.getPrice(), manufacturerStub, sup.getShippingDays());
		
		// Customer
		final CustomerStub customerStub = new CustomerStub(cm.getId(), cm.getEmail(), cm.getJoined(), cm.getLastName(), cm.getFirstName(), cm.getAddress(), cm.getTelephone());
		
		
		return new OrderStub(order.getId(), supplierStub, customerStub, order.getPrice(), order.getShippedOn(), order.getShipmentDue(), order.getDelivered()); 
	}
		
	
	@Override
	public List<OrderStub> to(List<Order> orders)
	{
		final List<OrderStub> result = new ArrayList<>();
		
		for (final Order order : orders) {
			result.add(this.to(order));
		}
		return result;
	}

}
