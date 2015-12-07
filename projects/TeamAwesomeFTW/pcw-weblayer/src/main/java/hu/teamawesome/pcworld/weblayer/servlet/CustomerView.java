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

import hu.teamawesome.pcworld.ejbservice.domain.CustomerStub;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;
import hu.teamawesome.pcworld.ejbservice.facade.CustomerFacade;

@WebServlet("/Customer")
public class CustomerView extends HttpServlet {

	private static final long serialVersionUID = -4068275526750462197L;
	private static final String PARAM_ID = "id";
	private static final String ATTRIBUTE_CUSTOMER = "customers";
	private static final String PAGE = "customer.jsp";

	private static final Logger LOGGER = Logger.getLogger(ProductView.class);

	@EJB
	private CustomerFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter(PARAM_ID);
		LOGGER.info("Get Customers by ID (" + id + ")");
		try {
			CustomerStub customer = this.facade.getCustomer(id);
			request.setAttribute(ATTRIBUTE_CUSTOMER, customer);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
		}
	    RequestDispatcher view = request.getRequestDispatcher(PAGE);
	    view.forward(request, response);
	}
}