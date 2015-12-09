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
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;
import hu.shruikan.somenewproject.ejbservice.facade.ProductOrderFacade;

@WebServlet("/ProductOrder")
public class ProductOrderViewServlet extends HttpServlet {

	private static final long serialVersionUID = -7058255202709402218L;
	private static final String PARAM_ID = "id";
	private static final String ATTRIBUTE_PRODUCTORDER = "productOrder";
	private static final String PAGE = "productOrder.jsp";

	private static final Logger LOGGER = Logger.getLogger(ProductOrderViewServlet.class);

	@EJB
	private ProductOrderFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get ProductOrder by user");
		
		Integer id = Integer.parseInt(request.getParameter(PARAM_ID));
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try {
			final ProductOrderStub productOrder = this.facade.getProductOrder((long)id);
			request.setAttribute(ATTRIBUTE_PRODUCTORDER, productOrder);
		} catch (final AdaptorException e) {
			LOGGER.error(e, e);
		}
		RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
