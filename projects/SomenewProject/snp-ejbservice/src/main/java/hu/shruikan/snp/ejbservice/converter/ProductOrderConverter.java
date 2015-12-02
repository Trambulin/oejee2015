package hu.shruikan.snp.ejbservice.converter;

import java.util.List;
import java.util.Date;

import javax.ejb.Local;

import hu.shruikan.snp.ejbservice.domain.ProductOrderStub;
import hu.shruikan.snp.persistence.entity.ProductOrder;

@Local
public interface ProductOrderConverter
{
	ProductOrderStub to(ProductOrder productOrder);
	
	List<ProductOrderStub> to(List<ProductOrder> productOrders);
}