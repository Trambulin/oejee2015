package hu.tram.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.tram.ejbservice.domain.CarStub;
import hu.tram.ejbservice.exception.FacadeException;
import hu.tram.ejbservice.facade.CarFacade;

@WebServlet("/CarPing")
public class CarPingServlet extends HttpServlet {

	private static final long serialVersionUID = -529800462207321373L;
	
	private static final Logger LOGGER = Logger.getLogger(CarPingServlet.class);

    @EJB
    private CarFacade facade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Get Car by user (Remote)");
        response.setCharacterEncoding("UTF-8");
        final PrintWriter out = response.getWriter();
        CarStub car = null;
		try {
			car = facade.getCar(new Long(0));
			LOGGER.info(car);
			out.println(car.toString());
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
            out.println(e.getLocalizedMessage());
		}
        out.close();
    }
}
