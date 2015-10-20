package hu.servlet;

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

import hu.domain.CarStub;
import hu.exception.FacadeException;
import hu.facade.CarFacade;

@WebServlet("/CarList")
public class CarListView extends HttpServlet {

	private static final long serialVersionUID = 901810735927283524L;

	private static final Logger LOGGER = Logger.getLogger(CarListView.class);

	private static final String ATTRIBUTE_CARS = "cars";
	private static final String PAGE = "list.jsp";

	@EJB
	private CarFacade facade;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get All Cars");
		try {
			final List<CarStub> cars = this.facade.getCars();
			request.setAttribute(ATTRIBUTE_CARS, cars);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}
}
