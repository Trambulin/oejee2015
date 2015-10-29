package hu.sas.weblayer.servlet;

import java.io.IOException;

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
@WebServlet("/SleepUser")
public class SleepViewByUser extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1170980948656428630L;
	
	private static final Logger LOGGER = Logger.getLogger(SleepViewByUser.class);
	private static final String PARAM_USERID = "userid";
	private static final String ATTRIBUTE_SLEEP = "sleep";
	private static final String PAGE = "sleepuser.jsp";
	
	@EJB
	private SleepFacade facade;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter(PARAM_USERID);
		LOGGER.info("Get sleep by userid: (" + userid + ")");
		
		try
		{
			SleepStub sleep = this.facade.getSleep(userid);
			request.setAttribute(ATTRIBUTE_SLEEP, sleep);			
			
		}
		catch(FacadeException e)
		{
			LOGGER.error(e, e);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
		
	}
	

}
