package hu.shruikan.somenewproject.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/Customer")
public class CustomerViewServlet extends HttpServlet {

	private static final long serialVersionUID = -7058255202709402218L;
	private static final String PARAM_ID = "id";
	private static final String ATTRIBUTE_CUSTOMER = "customer";
	private static final String PAGE = "customer.jsp";

	private static final Logger LOGGER = Logger.getLogger(CustomerPingServlet.class);

	@EJB
	private CustomerFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get Customer by user");
		
		Integer id = Integer.parseInt(request.getParameter(PARAM_ID));
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try {
			final CustomerStub customer = this.facade.getCustomer((long)id);
			request.setAttribute(ATTRIBUTE_CUSTOMER, customer);
			// out.println(customer.toString());
		} catch (final AdaptorException e) {
			LOGGER.error(e, e);
			// out.println(e.getLocalizedMessage());
		}
		// out.close();
		RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
