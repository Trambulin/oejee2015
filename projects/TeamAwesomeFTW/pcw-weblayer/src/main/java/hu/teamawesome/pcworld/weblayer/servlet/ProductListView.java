package hu.teamawesome.pcworld.weblayer.servlet;

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

//import hu.teamawesome.pcworld.ejbservice.domain.ProductCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.StorageStub;
import hu.teamawesome.pcworld.ejbservice.exception.AdaptorException;
import hu.teamawesome.pcworld.ejbservice.facade.StorageFacade;

@WebServlet("/ProductList")
public class ProductListView extends HttpServlet {

	private static final long serialVersionUID = -1977646750178615187L;

	private static final Logger LOGGER = Logger.getLogger(ProductListView.class);

	private static final String ATTRIBUTE_PRODUCTS = "products";
	private static final String PAGE = "list.jsp";

	@EJB
	private StorageFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get All Products");
		try {
			final List<StorageStub> products = this.facade.getProducts(); //new ProductCriteria());
			request.setAttribute(ATTRIBUTE_PRODUCTS, products);
		} catch (final AdaptorException e) {
			LOGGER.error(e, e);
		}
		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
