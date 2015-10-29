package hu.nik.condominium.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;

import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.ejbservice.facade.UserFacade;

@WebServlet("/UserView")//@WebServlet(name = "/UserView")
public class UserView extends HttpServlet{

	@EJB
	private UserFacade facade;

    private static final Logger logger=Logger.getLogger(UserView.class);

    private static final String ATTRIBUTE_LOGIN="login";
    private static final String ATTRIBURE_USER="user";
    private static final String PAGE="userView.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        final String login=request.getParameter(ATTRIBUTE_LOGIN);
        try {
            request.setAttribute(ATTRIBURE_USER, facade.getUser(login));
        } catch (FacadeException e) {
            e.printStackTrace();
            logger.error(e, e);
        }catch(NumberFormatException nfe){
            logger.info("Tried to query an User with invalid login: "+login);
        }
        final RequestDispatcher view=request.getRequestDispatcher(PAGE);
        view.forward(request,response);
    
    }
    
   
	
}
