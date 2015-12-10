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

import hu.shruikan.somenewproject.ejbservice.domain.CustomerStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;
import hu.shruikan.somenewproject.ejbservice.facade.CustomerFacade;

@WebServlet("/CustomerList")
public class CustomerListViewServlet extends HttpServlet {

	private static final long serialVersionUID = -7058255202709402218L;
	private static final String ATTRIBUTE_CUSTOMERS = "customers";
	private static final String PAGE = "customer-list.jsp";

	private static final Logger LOGGER = Logger.getLogger(CustomerPingServlet.class);

	@EJB
	private CustomerFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get Customer by user");
		
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try {
			final List<CustomerStub> customers = this.facade.getAllCustomers();
			request.setAttribute(ATTRIBUTE_CUSTOMERS, customers);
		} catch (final AdaptorException e) {
			LOGGER.error(e, e);
		}
		RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
