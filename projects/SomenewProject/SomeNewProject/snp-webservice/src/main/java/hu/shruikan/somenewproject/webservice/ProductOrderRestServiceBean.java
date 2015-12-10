package hu.shruikan.somenewproject.webservice;

import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import hu.shruikan.somenewproject.ejbservice.domain.ProductOrderStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;
import hu.shruikan.somenewproject.ejbservice.facade.ProductOrderFacade;

@Stateless
public class ProductOrderRestServiceBean implements ProductOrderRestService {

	private static final Logger LOGGER = Logger.getLogger(ProductOrderRestServiceBean.class);

	@EJB
	private ProductOrderFacade productOrderFacade;
	
	@Override
	public ProductOrderStub getProductOrder(Long id) throws AdaptorException {
		LOGGER.info("Get ProductOrder (" + id + ")");
		return this.productOrderFacade.getProductOrder(id);
	}
	
	@Override
	public void addProductOrder(Integer customerId, Integer productId, Integer quantity) throws AdaptorException {
		LOGGER.info("Create new ProductOrder");
		Random r = new Random();
		String productOrderNumber = "ON" + (r.nextInt(8999) + 1000);		
		this.productOrderFacade.create((long)customerId, (long)productId, productOrderNumber, quantity);
	}

	@Override
	public List<ProductOrderStub> getAllProductOrders() throws AdaptorException {
		LOGGER.info("Get all ProductOrders");
		return this.productOrderFacade.getAllProductOrders();
	}
	
	@Override
	public ProductOrderStub setDelivered(Long id, Boolean delivered) throws AdaptorException {
		LOGGER.info("Set ProductOrder delivered");
		return this.productOrderFacade.setDelivered(id, delivered);
	}
	
	/*
	@Override
	public void removeProductOrder(Long id) throws AdaptorException {
		LOGGER.info("Remove ProductOrder (" + id + ")");
		this.productOrderFacade.removeProductOrder(id);
	}
	*/
	
	@Override
	public Response optionsAll(String path) {
		return Response.status(Response.Status.NO_CONTENT).build();
	}

}
