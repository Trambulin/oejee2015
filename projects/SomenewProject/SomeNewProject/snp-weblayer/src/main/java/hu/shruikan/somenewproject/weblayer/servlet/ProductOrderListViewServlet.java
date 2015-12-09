package hu.shruikan.somenewproject.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.shruikan.somenewproject.ejbservice.domain.ProductOrderStub;
import hu.shruikan.somenewproject.ejbservice.domain.ProductStub;
import hu.shruikan.somenewproject.ejbservice.domain.CustomerStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;
import hu.shruikan.somenewproject.ejbservice.facade.ProductOrderFacade;
import hu.shruikan.somenewproject.ejbservice.facade.ProductFacade;
import hu.shruikan.somenewproject.ejbservice.facade.CustomerFacade;

@WebServlet("/ProductOrderList")
public class ProductOrderListViewServlet extends HttpServlet {

	private static final long serialVersionUID = -7058255202709402218L;
	private static final String PARAM_ID = "id";
	private static final String ATTRIBUTE_PRODUCTS = "products";
	private static final String ATTRIBUTE_CUSTOMERS = "customers";
	private static final String ATTRIBUTE_PRODUCTORDERS = "productOrders";
	private static final String PAGE = "productOrderList.jsp";

	private static final Logger LOGGER = Logger.getLogger(ProductOrderListViewServlet.class);

	@EJB
	private ProductOrderFacade productOrderFacade;
	
	@EJB
	private CustomerFacade customerFacade;

	@EJB
	private ProductFacade productFacade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get ProductOrders");

		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try {
			final List<ProductOrderStub> productOrders = this.productOrderFacade.getAllProductOrders();
			final List<CustomerStub> customers = this.customerFacade.getAllCustomers();
			final List<ProductStub> products = this.productFacade.getAllProducts();
			request.setAttribute(ATTRIBUTE_CUSTOMERS, customers);
			request.setAttribute(ATTRIBUTE_PRODUCTS, products);
			request.setAttribute(ATTRIBUTE_PRODUCTORDERS, productOrders);
		} catch (final AdaptorException e) {
			LOGGER.error(e, e);
		}
		RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
