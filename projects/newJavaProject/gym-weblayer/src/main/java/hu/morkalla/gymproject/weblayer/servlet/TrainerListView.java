package hu.morkalla.gymproject.weblayer.servlet;

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

import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.ejbservice.exception.FacadeException;
import hu.morkalla.gymproject.ejbservice.facade.TrainerFacade;

@WebServlet("/TrainerList")
public class TrainerListView extends HttpServlet {

	private static final long serialVersionUID = -3191793546507977685L;

	private static final Logger LOGGER = Logger.getLogger(TrainerListView.class);

	private static final String ATTRIBUTE_TRAINERS = "trainers";
	private static final String PAGE = "list.jsp";

	@EJB
	private TrainerFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get All Trainers");
		try {
			final List<TrainerStub> trainers = this.facade.getTrainers();
			request.setAttribute(ATTRIBUTE_TRAINERS, trainers);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
