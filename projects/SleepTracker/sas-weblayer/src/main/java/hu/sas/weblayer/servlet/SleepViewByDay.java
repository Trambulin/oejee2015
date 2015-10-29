package hu.sas.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.sas.ejbservice.domain.SleepStub;
import hu.sas.ejbservice.exception.FacadeException;

@WebServlet("/SleepDay")
public class SleepViewByDay extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -110442889291029602L;
	
	private static final Logger LOGGER = Logger.getLogger(SleepViewByDay.class);
	private static final String PARAM_DAY = "day";
	private static final String ATTRIBUTE_SLEEP = "sleepDay";
	private static final String PAGE = "sleepday.jsp";
	
	@EJB
	private SleepFacade facade;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter(PARAM_DAY);
		LOGGER.info("Get sleeps by day (" + date + ")");
		
		try
		{
			SleepStub sleep = this.facade.getSleep(date);
			request.setAttribute(ATTRIBUTE_SLEEP, sleep);		
			
		}
		catch(FacadeException e)
		{
			LOGGER.error(e, e);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE);
		dispatcher.forward(request, response);
		
	}
	

}
