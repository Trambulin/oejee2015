package hu.marcibbx.JEEzusom.weblayer.servlet;

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

import hu.marcibbx.JEEzusom.ejbservice.domain.AccountStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;
import hu.marcibbx.JEEzusom.ejbservice.facade.AccountFacade;

@WebServlet("/addaccount")
public class AccountListViewServlet extends HttpServlet {

	private static final long serialVersionUID = -7058255202709402218L;
	private static final String ATTRIBUTE_ACCOUNTS = "accounts";
	private static final String PAGE = "account-list.jsp";

	private static final Logger LOGGER = Logger.getLogger(AccountListViewServlet.class);

	@EJB
	private AccountFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get Account by user");
		
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try {
			final List<AccountStub> accounts = this.facade.getAllAccounts();
			request.setAttribute(ATTRIBUTE_ACCOUNTS, accounts);
		} catch (final AdaptorException e) {
			LOGGER.error(e, e);
		}
		RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
