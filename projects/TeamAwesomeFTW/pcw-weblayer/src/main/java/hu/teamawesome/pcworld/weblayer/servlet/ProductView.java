package hu.teamawesome.pcworld.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.ejbservice.domain.StorageStub;
import hu.teamawesome.pcworld.ejbservice.exception.AdaptorException;
import hu.teamawesome.pcworld.ejbservice.facade.StorageFacade;

@WebServlet("/Product")
public class ProductView extends HttpServlet {

	private static final long serialVersionUID = -4068275526750462197L;
	private static final String PARAM_ID = "id";
	private static final String ATTRIBUTE_PRODUCT = "products";
	private static final String PAGE = "product.jsp";

	private static final Logger LOGGER = Logger.getLogger(ProductView.class);

	@EJB
	private StorageFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = request.getParameter(PARAM_ID);
		LOGGER.info("Get Product by ID (" + id + ")");
		
		try {
			long l_id = Long.parseLong(id);
			StorageStub product = this.facade.getProduct(l_id);
			request.setAttribute(ATTRIBUTE_PRODUCT, product);
		} catch (AdaptorException e) {
			LOGGER.error(e, e);
		}
	    RequestDispatcher view = request.getRequestDispatcher(PAGE);
	    view.forward(request, response);
	}
}