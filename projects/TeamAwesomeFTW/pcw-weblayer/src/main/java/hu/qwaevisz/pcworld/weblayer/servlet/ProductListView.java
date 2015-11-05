package hu.qwaevisz.pcworld.weblayer.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//import hu.qwaevisz.pcworld.ejbservice.domain.ProductCriteria;
import hu.qwaevisz.pcworld.ejbservice.domain.ProductStub;
import hu.qwaevisz.pcworld.ejbservice.exception.FacadeException;
import hu.qwaevisz.pcworld.ejbservice.facade.ProductFacade;

@WebServlet("/ProductList")
public class ProductListView extends HttpServlet {

	private static final long serialVersionUID = -1977646750178615187L;

	private static final Logger LOGGER = Logger.getLogger(ProductListView.class);

	private static final String ATTRIBUTE_PRODUCTS = "products";
	private static final String PAGE = "list.jsp";

	@EJB
	private ProductFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get All Products");
		try {
			final List<ProductStub> products = this.facade.getProducts(); //new ProductCriteria());
			request.setAttribute(ATTRIBUTE_PRODUCTS, products);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
