package hu.morkalla.gymproject.weblayer.servlet;

import java.io.IOException;

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

@WebServlet("/Trainer")
public class TrainerView extends HttpServlet {

	private static final long serialVersionUID = -2194994281196781775L;
	private static final String PARAM_NAME = "name";
	private static final String ATTRIBUTE_TRAINER = "trainer";
	private static final String PAGE = "trainer.jsp";

	private static final Logger LOGGER = Logger.getLogger(TrainerView.class);

	@EJB
	private TrainerFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter(PARAM_NAME);
		LOGGER.info("Get Trainer by name (" + name + ")");
		try {
			TrainerStub trainer = this.facade.getTrainer(name);
			request.setAttribute(ATTRIBUTE_TRAINER, trainer);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
		}
		RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
