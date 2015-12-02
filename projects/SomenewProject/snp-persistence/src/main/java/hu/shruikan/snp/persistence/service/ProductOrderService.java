package hu.shruikan.snp.persistence.service;

import java.util.List;
import javax.ejb.Local;
import java.util.Date;

import hu.shruikan.snp.persistence.entity.ProductOrder;
import hu.shruikan.snp.persistence.entity.Product;
import hu.shruikan.snp.persistence.entity.Customer;
import hu.shruikan.snp.persistence.exception.PersistenceServiceException;

@Local
public interface ProductOrderService
{
	ProductOrder create(String number, Customer customer, Integer quantity, Product product) throws PersistenceServiceException;
	
	ProductOrder read(Integer id) throws PersistenceServiceException;
	
	ProductOrder read(Boolean delivered) throws PersistenceServiceException;
	
	List<ProductOrder> readAllCustomer(Integer customerId) throws PersistenceServiceException;
	
	void delete(Integer id) throws PersistenceServiceException;
}