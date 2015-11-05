package hu.oe.pancakestore.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.ejbservice.domain.OrderMasterStub;
import hu.oe.pancakestore.ejbservice.exception.FacadeException;
import hu.oe.pancakestore.ejbservice.facade.OrderMasterFacade;



@WebServlet("/OrderMasterPing")
public class OrderMasterPingServlet extends HttpServlet {

    private static final long serialVersionUID = -7058255202709402208L;

    private static final Logger LOGGER = Logger.getLogger(OrderMasterPingServlet.class);

    @EJB
    private OrderMasterFacade facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Get OrderMaster by id");
        response.setCharacterEncoding("UTF-8");
        final PrintWriter out = response.getWriter();
        try {
            final OrderMasterStub ordermaster = facade.getOrderMaster(1L);
            out.println(ordermaster.toString());
        } catch (final FacadeException e) {
            LOGGER.error(e, e);
            out.println(e.getLocalizedMessage());
        }
        out.close();
    }

}
