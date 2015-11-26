package hu.qwaevisz.pcworld.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.qwaevisz.pcworld.ejbservice.domain.ProductStub;
import hu.qwaevisz.pcworld.ejbservice.exception.FacadeException;
import hu.qwaevisz.pcworld.ejbservice.facade.ProductFacade;

@WebServlet("/Product")
public class ProductView extends HttpServlet {

	private static final long serialVersionUID = -4068275526750462197L;
	private static final String PARAM_ID = "id";
	private static final String ATTRIBUTE_BOOK = "book";
	private static final String PAGE = "product.jsp";

	private static final Logger LOGGER = Logger.getLogger(ProductView.class);

	@EJB
	private ProductFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Comment
		
		String id = request.getParameter(PARAM_ID);
		LOGGER.info("Get Book by ID ("+id+")");
		try {
			ProductStub book = this.facade.getProduct(id);
			request.setAttribute(ATTRIBUTE_BOOK, book);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
		}
	    RequestDispatcher view = request.getRequestDispatcher(PAGE);
	    view.forward(request, response); 
	}
}