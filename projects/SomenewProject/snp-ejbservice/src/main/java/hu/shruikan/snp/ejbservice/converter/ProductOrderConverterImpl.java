package hu.shruikan.snp.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.ejb.Stateless;

import hu.shruikan.snp.ejbservice.domain.ProductOrderStub;
import hu.shruikan.snp.ejbservice.domain.CustomerStub;
import hu.shruikan.snp.ejbservice.domain.CustomerRoleStub;
import hu.shruikan.snp.ejbservice.domain.ProductStub;
import hu.shruikan.snp.ejbservice.domain.AttributeStub;
import hu.shruikan.snp.persistence.entity.Customer;
import hu.shruikan.snp.persistence.entity.ProductOrder;
import hu.shruikan.snp.persistence.entity.Product;
import hu.shruikan.snp.persistence.entity.Attribute;
import hu.shruikan.snp.persistence.entity.trunk.CustomerRole;

@Stateless
public class ProductOrderConverterImpl implements ProductOrderConverter 
{

	@Override
	public ProductOrderStub to(ProductOrder productOrder) 
	{
		final Product product = productOrder.getProduct();
		final ProductStub productStub = new ProductStub(product.getSerial(), product.getName(), product.getCreateDate());
		final Customer customer = productOrder.getCustomer();
		final CustomerRoleStub role = CustomerRoleStub.valueOf(customer.getRole().toString());
		final CustomerStub customerStub = new CustomerStub(customer.getName(), customer.getPassword(), role, customer.getCreateDate());
		return new ProductOrderStub(productOrder.getNumber(), customerStub, productOrder.getQuantity(), productStub, productOrder.getDelivered());
	}

	@Override
	public List<ProductOrderStub> to(List<ProductOrder> productOrders) 
	{
		final List<ProductOrderStub> result = new ArrayList<>();
		for (final ProductOrder productOrder : productOrders) 
		{
			result.add(this.to(productOrder));
		}
		return result;
	}
}
