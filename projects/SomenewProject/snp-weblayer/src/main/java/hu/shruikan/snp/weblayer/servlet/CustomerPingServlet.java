package hu.shruikan.snp.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.shruikan.snp.ejbservice.domain.CustomerStub;
import hu.shruikan.snp.ejbservice.exception.AdaptorException;
import hu.shruikan.snp.ejbservice.facade.CustomerFacade;

@WebServlet("/CustomerPing")
public class CustomerPingServlet extends HttpServlet 
{

	private static final long serialVersionUID = -7058255202709402208L;

	private static final Logger LOGGER = Logger.getLogger(CustomerPingServlet.class);

	@EJB
	private CustomerFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		LOGGER.info("Get Customer by id");
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try 
		{
			final CustomerStub customer = this.facade.getCustomer("WI53085");
			out.println(customer.toString());
		}
		catch (final AdaptorException e) 
		{
			LOGGER.error(e, e);
			out.println(e.getLocalizedMessage());
		}
		out.close();
	}

}
