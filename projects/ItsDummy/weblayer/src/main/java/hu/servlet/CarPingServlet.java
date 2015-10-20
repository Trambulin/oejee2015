package hu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.exception.FacadeException;
import hu.facade.CarFacade;
import hu.domain.CarStub;

@WebServlet("/CarPing")
public class CarPingServlet extends HttpServlet {

	private static final long serialVersionUID = -529800462207321373L;

	private static final Logger LOGGER = Logger.getLogger(CarPingServlet.class);

    @EJB
    private CarFacade facade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Get Car by user");
        response.setCharacterEncoding("UTF-8");
        final PrintWriter out = response.getWriter();
        try {
        	Long lid=new Long(0);
            final CarStub car = facade.getCar(lid);
            out.println(car.toString());
        } catch (final FacadeException e) {
            LOGGER.error(e, e);
            out.println(e.getLocalizedMessage());
        }
        out.close();
    }
}
