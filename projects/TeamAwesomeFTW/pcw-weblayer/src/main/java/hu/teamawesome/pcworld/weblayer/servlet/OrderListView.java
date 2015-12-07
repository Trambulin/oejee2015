package hu.teamawesome.pcworld.weblayer.servlet;

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

//import hu.teamawesome.pcworld.ejbservice.domain.OrderCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.OrderStub;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;
import hu.teamawesome.pcworld.ejbservice.facade.OrderFacade;

@WebServlet("/OrderList")
public class OrderListView extends HttpServlet {

	private static final long serialVersionUID = -1977646750178615187L;

	private static final Logger LOGGER = Logger.getLogger(OrderListView.class);

	private static final String ATTRIBUTE_ORDERS = "orders";
	private static final String PAGE = "olist.jsp";

	@EJB
	private OrderFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get All Orders");
		try {
			final List<OrderStub> orders = this.facade.getOrders(); //new ProductCriteria());
			request.setAttribute(ATTRIBUTE_ORDERS, orders);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
