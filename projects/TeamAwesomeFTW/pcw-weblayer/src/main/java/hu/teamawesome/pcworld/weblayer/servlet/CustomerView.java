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

import hu.teamawesome.pcworld.ejbservice.domain.CustomerStub;
import hu.teamawesome.pcworld.ejbservice.domain.OrderCriteria;
import hu.teamawesome.pcworld.ejbservice.domain.OrderStub;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;
import hu.teamawesome.pcworld.ejbservice.facade.CustomerFacade;
import hu.teamawesome.pcworld.ejbservice.facade.OrderFacade;

@WebServlet("/Customer")
public class CustomerView extends HttpServlet {

	private static final long serialVersionUID = -4068275526750462197L;
	private static final String PARAM_ID = "id";
	private static final String ATTRIBUTE_CUSTOMER = "customer";
	private static final String ATTRIBUTE_ORDERS = "orders";
	private static final String PAGE = "customer.jsp";

	private static final Logger LOGGER = Logger.getLogger(ProductView.class);

	@EJB
	private CustomerFacade customerFacade;
	
	@EJB
	private OrderFacade orderFacade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String s_id = request.getParameter(PARAM_ID);
		LOGGER.info("Get Customers by ID and orders (" + s_id + ")");
		
		try {
			
			
			CustomerStub customer = this.customerFacade.getCustomer(s_id);
			request.setAttribute(ATTRIBUTE_CUSTOMER, customer);
			
			long id = Long.parseLong(s_id);
			final List<OrderStub> orders = this.orderFacade.getOrders(new OrderCriteria(id, true));
			request.setAttribute(ATTRIBUTE_ORDERS, orders);
			
			
			
			
		} catch (FacadeException e) {
			LOGGER.error(e, e);
		}
	    RequestDispatcher view = request.getRequestDispatcher(PAGE);
	    view.forward(request, response);
	}
}