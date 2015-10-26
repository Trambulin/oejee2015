package hu.qwaevisz.bookstore.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.qwaevisz.bookstore.ejbservice.domain.BookStub;
import hu.qwaevisz.bookstore.ejbservice.domain.CustomerStub;
import hu.qwaevisz.bookstore.ejbservice.exception.FacadeException;

import hu.qwaevisz.bookstore.ejbservice.facade.CustomerFacade;

@WebServlet("/Customer")
public class CustomerView extends HttpServlet {

	private static final long serialVersionUID = -4068275526750462197L;
	private static final String PARAM_NAME = "name";
	private static final String ATTRIBUTE_CUSTOMER = "customer";
	private static final String PAGE = "book.jsp";

	private static final Logger LOGGER = Logger.getLogger(CustomerView.class);

	@EJB
	private CustomerFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter(PARAM_NAME);
		LOGGER.info("Get Customer by NAME ("+name+")");
		try {
			CustomerStub customer = this.facade.getCustomer(name);
			request.setAttribute(ATTRIBUTE_CUSTOMER, customer);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
		}
	    RequestDispatcher view = request.getRequestDispatcher(PAGE);
	    view.forward(request, response); 
	}

}