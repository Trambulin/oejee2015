package hu.marcibbx.JEEzusom.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.marcibbx.JEEzusom.ejbservice.domain.AccountStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;
import hu.marcibbx.JEEzusom.ejbservice.facade.AccountFacade;

@WebServlet("/AccountPing")
public class AccountPingServlet extends HttpServlet {

	private static final long serialVersionUID = -7058255202709402208L;

	private static final Logger LOGGER = Logger.getLogger(AccountPingServlet.class);

	@EJB
	private AccountFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get Account by user");
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try {
			final AccountStub account = this.facade.getAccount("WI53085");
			out.println(account.toString());
		} catch (final AdaptorException e) {
			LOGGER.error(e, e);
			out.println(e.getLocalizedMessage());
		}
		out.close();
	}

}
