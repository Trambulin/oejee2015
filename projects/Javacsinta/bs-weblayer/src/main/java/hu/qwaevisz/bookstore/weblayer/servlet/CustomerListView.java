//package hu.qwaevisz.bookstore.weblayer.servlet;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.ejb.EJB;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//
//import hu.qwaevisz.bookstore.ejbservice.domain.BookCriteria;
//import hu.qwaevisz.bookstore.ejbservice.domain.BookStub;
//import hu.qwaevisz.bookstore.ejbservice.domain.CustomerStub;
//import hu.qwaevisz.bookstore.ejbservice.exception.FacadeException;
//import hu.qwaevisz.bookstore.ejbservice.facade.BookFacade;
//import hu.qwaevisz.bookstore.ejbservice.facade.CustomerFacade;
//
//@WebServlet("/CustomerList")
//public class CustomerListView extends HttpServlet {
//
//	private static final long serialVersionUID = -1977646750178615187L;
//
//	private static final Logger LOGGER = Logger.getLogger(CustomerListView.class);
//
//	private static final String ATTRIBUTE_CUSTOMERS = "customers";
//	private static final String PAGE = "list.jsp";
//
//	@EJB
//	private CustomerFacade facade;
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		LOGGER.info("Get All Books");
//		try {
//			final List<CustomerStub> customers = this.facade.getCustomer(new BookCriteria()));
//			request.setAttribute(ATTRIBUTE_CUSTOMERS, customers);
//		} catch (final FacadeException e) {
//			LOGGER.error(e, e);
//		}
//		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
//		view.forward(request, response);
//	}
//
//}