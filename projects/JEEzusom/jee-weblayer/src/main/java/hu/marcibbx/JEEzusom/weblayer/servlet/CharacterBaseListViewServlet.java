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

import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;
import hu.marcibbx.JEEzusom.ejbservice.facade.CharacterBaseFacade;

@WebServlet("/listcharacters")
public class CharacterBaseListViewServlet extends HttpServlet {

	private static final long serialVersionUID = -7058255202709402218L;
	private static final String ATTRIBUTE_CHARACTERS = "characters";
	private static final String PAGE = "character-list.jsp";
	private static final String PARAM_ACCOUNT_ID = "accountId";
	private static final Logger LOGGER = Logger.getLogger(CharacterBaseListViewServlet.class);

	@EJB
	private CharacterBaseFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get Characters by accountId");
		Long accountId =  Long.parseLong(request.getParameter(PARAM_ACCOUNT_ID), 10)   ;
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try {
			final List<CharacterBaseStub> characters = this.facade.getCharacterBases(accountId);
			request.setAttribute(ATTRIBUTE_CHARACTERS, characters);
		} catch (final AdaptorException e) {
			LOGGER.error(e, e);
		}
		RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
