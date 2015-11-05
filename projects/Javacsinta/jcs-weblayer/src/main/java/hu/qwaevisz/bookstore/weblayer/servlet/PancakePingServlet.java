package hu.qwaevisz.bookstore.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.qwaevisz.bookstore.ejbservice.domain.PancakeStub;
import hu.qwaevisz.bookstore.ejbservice.exception.FacadeException;
import hu.qwaevisz.bookstore.ejbservice.facade.PancakeFacade;


@WebServlet("/PancakePing")
public class PancakePingServlet  extends HttpServlet{
	private static final long serialVersionUID = -7058255202709402208L;

    private static final Logger LOGGER = Logger.getLogger(PancakePingServlet.class);

    @EJB
    private PancakeFacade facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Get Pancake by name");
        response.setCharacterEncoding("UTF-8");
        final PrintWriter out = response.getWriter();
        try {
            final PancakeStub pancake = facade.getPancake("CSOKIS PALACSINTA");
            out.println(pancake.toString());
        } catch (final FacadeException e) {
            LOGGER.error(e, e);
            out.println(e.getLocalizedMessage());
        }
        out.close();
    }
}
