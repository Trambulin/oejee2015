package hu.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.ejbserviceclient.domain.CarStub;
import hu.ejbserviceclient.exception.ServiceException;
import hu.ejbserviceclient.CarFacadeRemote;
import hu.client.CarClient;

@WebServlet("/CarPing")
public class CarPingServlet extends HttpServlet {

	private static final long serialVersionUID = -529800462207321373L;

	private static final Logger LOGGER = Logger.getLogger(CarPingServlet.class);

    @EJB
    private CarFacadeRemote facade;
    
    private CarClient client;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Get Car by user (Remote)");
        response.setCharacterEncoding("UTF-8");
        final PrintWriter out = response.getWriter();
        Long lid=new Long(0);
        client=new CarClient();
        final CarStub car = client.invoke(lid);
        out.println(car.toString());
        out.close();
    }
}
