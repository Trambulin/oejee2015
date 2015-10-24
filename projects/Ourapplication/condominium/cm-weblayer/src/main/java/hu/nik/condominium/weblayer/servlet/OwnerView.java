package hu.nik.condominium.weblayer.servlet;


import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.ejbservice.facade.OwnerFacade;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OwnerView")//@WebServlet(name = "/OwnerView") !!!
public class OwnerView extends HttpServlet {

    @EJB
    private OwnerFacade facade;

    private static final Logger logger=Logger.getLogger(CondominiumView.class);

    private static final String ATTRIBUTE_ID="id";
    private static final String ATTRIBURE_OWNER="owner";
    private static final String PAGE="ownerView.jsp";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            final String id=request.getParameter(ATTRIBUTE_ID);
        try {
            request.setAttribute(ATTRIBURE_OWNER, facade.getOwner(Long.parseLong(id)));
        } catch (FacadeException e) {
            e.printStackTrace();
            logger.error(e, e);
        }catch(NumberFormatException nfe){
            logger.info("Tried to query an owner with invalid id: "+id);
        }
        RequestDispatcher view=request.getRequestDispatcher(PAGE);
        view.forward(request, response);
    }
}
