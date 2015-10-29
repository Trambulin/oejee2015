package hu.sas.weblayer.servlet;

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

import hu.sas.ejbservice.domain.SleepStub;
import hu.sas.ejbservice.exception.FacadeException;

@WebServlet("/SleepList")
public class SleepListView extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -383141041354897279L;
	private static final Logger logger = Logger.getLogger(SleepListView.class);
	
	private static final String ATTRIBUTE_SLEEPS = "sleeps";
	private static final String PAGE = "list.jsp";
	
	@EJB
	private SleepFacede facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Get All Sleeps");
		response.setCharacterEncoding("UTF-8");
		final PrintWriter writer = response.getWriter();
		try {
			final List<SleepStub> sleeps = this.facade.getSleeps(new SleepCriteria());
			writer.println(sleeps.toString());
		} catch (final FacadeException e) {
			logger.error(e, e);
			writer.println(e.getLocalizedMessage());
		}
		writer.close();
	}
	

}
