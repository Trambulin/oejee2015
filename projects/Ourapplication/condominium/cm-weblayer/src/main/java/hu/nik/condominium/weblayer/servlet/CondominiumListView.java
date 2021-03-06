package hu.nik.condominium.weblayer.servlet;

import hu.nik.condominium.ejbservice.domain.CondominiumCriteria;
import hu.nik.condominium.ejbservice.domain.CondominiumStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.ejbservice.facade.CondominiumFacade;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CondominiumList")
public class CondominiumListView extends HttpServlet {
	private static final long serialVersionUID = 666L;
	private static final Logger LOGGER = Logger.getLogger(CondominiumListView.class);

	private static final String ATTRIBUTE_CONDOMINIUMS = "condominiums";
	private static final String PAGE = "listCondominiums.jsp";

	@EJB
	private CondominiumFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LOGGER.info("Get All Condominiums");
		response.setCharacterEncoding("UTF-8");

		try {
			final List<CondominiumStub> coundominiums = this.facade.getCondominiums(new CondominiumCriteria());
			request.setAttribute(ATTRIBUTE_CONDOMINIUMS, coundominiums);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
		// response.getOutputStream().print("test");
		// response.getOutputStream().flush();
	}
}
