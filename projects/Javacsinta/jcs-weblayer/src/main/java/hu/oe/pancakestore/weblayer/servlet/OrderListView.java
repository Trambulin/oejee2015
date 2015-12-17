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

import hu.oe.pancakestore.serviceclient.domain.OrderHeaderStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;
import hu.oe.pancakestore.ejbservice.facade.OrderHeaderFacade;

@WebServlet("/OrderList")
public class OrderListView extends HttpServlet {

	private static final long serialVersionUID = 2250783603124823306L;

	/**
	 * 
	 */

	private static final Logger LOGGER = Logger.getLogger(OrderListView.class);

	private static final String ATTRIBUTE_ORDERS = "orders";
	private static final String PAGE = "order-list.jsp";

	@EJB
	private OrderHeaderFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get all orders");
		try {
			final List<OrderHeaderStub> orders = this.facade.getOrderHeaders();
			request.setAttribute(ATTRIBUTE_ORDERS, orders);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
