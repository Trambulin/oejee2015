package hu.oe.pancakestore.weblayer.servlet;

import java.io.IOException;

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

@WebServlet("/Pancake")
public class PancakeView extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8018734642515832458L;
	private static final String PARAM_NAME = "name";
	private static final String ATTRIBUTE_PANCAKE = "pancake";
	private static final String PAGE = "pancake.jsp";

	private static final Logger LOGGER = Logger.getLogger(PancakeView.class);

	@EJB
	private PancakeFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter(PARAM_NAME);
		LOGGER.info("Get pancake by name ("+name+")");
		try {
			PancakeStub pancake = this.facade.getPancake(name);
			request.setAttribute(ATTRIBUTE_PANCAKE, pancake);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
		}
	    RequestDispatcher view = request.getRequestDispatcher(PAGE);
	    view.forward(request, response); 
	}

}
