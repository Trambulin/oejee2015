package hu.morkalla.gymproject.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.morkalla.gymproject.ejbservice.domain.TrainerStub;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.ejbservice.facade.TrainerFacade;

@WebServlet("/TrainerPing")
public class TrainerPingServlet extends HttpServlet {

	private static final long serialVersionUID = 55656058357518174L;

	private static final Logger LOGGER = Logger.getLogger(TrainerPingServlet.class);

	@EJB
	private TrainerFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get Trainer by user");
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try {
			final TrainerStub trainer = facade.getTrainer("Tolnay Róbert");
			out.println(trainer.toString());
		} catch (final AdaptorException e) {
			LOGGER.error(e, e);
			out.println(e.getLocalizedMessage());
		}
		out.close();
	}

}
