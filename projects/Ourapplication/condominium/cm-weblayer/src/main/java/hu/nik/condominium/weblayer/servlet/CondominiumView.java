package hu.nik.condominium.weblayer.servlet;

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


@WebServlet("/CondominiumView")
public class CondominiumView extends HttpServlet{
    private static final Logger logger=Logger.getLogger(CondominiumView.class);
    private static final String ATTRIBUTE_ID="id";
    private static final String ATTRIBUTE_CONDOMINIUM="condominium";
    private static final String PAGE="condominium.jsp";

    @EJB
    private CondominiumFacade facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter(ATTRIBUTE_ID);
        request.setCharacterEncoding("UTF-8");
        logger.info("Get condominium by id");
        try {
            CondominiumStub stub=facade.getCondonimium(Long.parseLong(id));
            request.setAttribute(ATTRIBUTE_CONDOMINIUM,stub);
        } catch (FacadeException e) {
            e.printStackTrace();
            logger.error(e,e);
        }catch(NumberFormatException nfe){
            logger.info("Tried to query a condominium with not number value");
        }
        final RequestDispatcher view=request.getRequestDispatcher(PAGE);
        view.forward(request,response);
    }
}
