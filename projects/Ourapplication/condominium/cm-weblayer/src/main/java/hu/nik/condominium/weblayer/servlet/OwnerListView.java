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

@WebServlet("/OwnerListView")
public class OwnerListView extends HttpServlet {

    @EJB
    private OwnerFacade facade;

    private static final Logger logger=Logger.getLogger(CondominiumView.class);

    private static final String ATTRIBURE_OWNER="owners";
    private static final String PAGE="ownerListView.jsp";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute(ATTRIBURE_OWNER, facade.getOwners());
        } catch (FacadeException e) {
            e.printStackTrace();
            logger.error(e, e);
        }
        final RequestDispatcher view=request.getRequestDispatcher(PAGE);
        view.forward(request,response);
    }
}
