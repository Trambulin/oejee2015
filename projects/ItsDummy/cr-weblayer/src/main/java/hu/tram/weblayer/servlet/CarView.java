package hu.weblayer.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.ejbservice.domain.CarStub;
import hu.ejbservice.exception.FacadeException;
import hu.ejbservice.facade.CarFacade;

@WebServlet("/Car")
public class CarView extends HttpServlet {

	private static final long serialVersionUID = -3591851850389706704L;
	private static final String PARAM_BM = "brand_model";
	private static final String ATTRIBUTE_CAR = "car";
	private static final String PAGE = "car.jsp";
	private static final Logger LOGGER = Logger.getLogger(CarView.class);

	@EJB
	private CarFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bm = request.getParameter(PARAM_BM);
		LOGGER.info("Get Car by Brand and Model name ("+bm+")");
		String paramBrand=bm.split(";")[0];
		String paramModel=bm.split(";")[1];
		try {
			CarStub car=null;
			List<CarStub> cars = this.facade.getCars();
			for(CarStub c : cars){
				if(c.getBrand().toString().equals(paramBrand) && c.getModel().equals(paramModel))
					car=c;
			}
			request.setAttribute(ATTRIBUTE_CAR, car);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
		}
	    RequestDispatcher view = request.getRequestDispatcher(PAGE);
	    view.forward(request, response); 
	}

}
