package hu.oe.pancakestore.weblayer.servlet;

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


import hu.oe.pancakestore.serviceclient.domain.PancakeStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;
import hu.oe.pancakestore.ejbservice.facade.PancakeFacade;

@WebServlet("/PancakeList")
public class PancakeListView extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5602073795060620225L;

	private static final Logger LOGGER = Logger.getLogger(PancakeListView.class);

	private static final String ATTRIBUTE_PANCAKES = "pancakes";
	private static final String PAGE = "pancake-list.jsp";

	@EJB
	private PancakeFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get all pancakes");
		try {
			final List<PancakeStub> pancakes = this.facade.getPancakes();
			request.setAttribute(ATTRIBUTE_PANCAKES, pancakes);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
