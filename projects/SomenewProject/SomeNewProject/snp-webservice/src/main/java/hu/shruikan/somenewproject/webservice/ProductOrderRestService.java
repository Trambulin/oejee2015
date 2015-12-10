package hu.shruikan.somenewproject.webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.FormParam;

import hu.shruikan.somenewproject.ejbservice.domain.ProductOrderStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;

@Path("/productOrder")
public interface ProductOrderRestService {

	@GET
	@Path("/{id}")
	@Produces("application/json")
	ProductOrderStub getProductOrder(@PathParam("id") Long id) throws AdaptorException;
	
	@POST
	@Path("/add")
	void addProductOrder(@FormParam("input-customer") Integer customerId, @FormParam("input-product") Integer productId, @FormParam("input-quantity") Integer quantity) throws AdaptorException;

	@GET
	@Path("/list")
	@Produces("application/json")
	List<ProductOrderStub> getAllProductOrders() throws AdaptorException;

	/*
	@DELETE
	@Path("/{id}")
	void removeProductOrder(@PathParam("id") Long id) throws AdaptorException;
	*/
	
	@OPTIONS
	@Path("{path:.*}")
	Response optionsAll(@PathParam("path") String path);

}
