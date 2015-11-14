package hu.nik.condominium.weblayer.servlet;

import hu.nik.condominium.ejbservice.domain.RepairCriteria;
import hu.nik.condominium.ejbservice.domain.RepairStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.ejbservice.facade.RepairFacade;
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

@WebServlet("/RepairList")
public class RepairListView extends HttpServlet {
    private static final long serialVersionUID = 666L;
    private static final Logger LOGGER = Logger.getLogger(RepairListView.class);

    private static final String ATTRIBUTE_REPAIRS = "repairs";
    private static final String PAGE = "listRepairs.jsp";

    @EJB
    private RepairFacade facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOGGER.info("Get All Repairs");
        try {
            final List<RepairStub> repairStubs = this.facade.getRepairs(new RepairCriteria());
            request.setAttribute(ATTRIBUTE_REPAIRS, repairStubs);
        } catch (final FacadeException e) {
            LOGGER.error(e, e);
        }
        final RequestDispatcher view = request.getRequestDispatcher(PAGE);
        view.forward(request, response);
    }
}
