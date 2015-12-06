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

import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.ejbservice.facade.TrainerFacade;
import hu.morkalla.gymproject.persistence.entity.TrainerContact;
import hu.morkalla.gymproject.persistence.entity.TrainerQualification;

@WebServlet("/AddTrainerService")
public class AddTrainerServlet extends HttpServlet {

	private static final long serialVersionUID = -7228111294859566334L;

	private static final Logger LOGGER = Logger.getLogger(AddTrainerServlet.class);

	private static final String ATTRIBUTE_NAME = "name";
	private static final String ATTRIBUTE_HEIGHT = "height";
	private static final String ATTRIBUTE_WEIGHT = "weight";

	private static final String ATTRIBUTE_CONTACT_TYPE = "contact_type";
	private static final String ATTRIBUTE_CONTACT_VALUE = "contact_value";

	private static final String ATTRIBUTE_QUALIFICATION_NAME = "qualification_name";
	private static final String ATTRIBUTE_QUALIFICATION_LEVEL = "qualification_level";
	private static final String ATTRIBUTE_QUALIFICATION_YEAR = "qualification_year";

	@EJB
	private TrainerFacade facade;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LOGGER.debug("Add Trainer");

		try {
			TrainerContact trainerContact = null;
			TrainerQualification trainerQualification = null;

			String name = request.getParameter(ATTRIBUTE_NAME);
			Integer height = Integer.parseInt(request.getParameter(ATTRIBUTE_HEIGHT));
			Integer weight = Integer.parseInt(request.getParameter(ATTRIBUTE_WEIGHT));

			final PrintWriter out = response.getWriter();

			out.println("Trainer added");
			out.println(name);
			out.println(height);
			out.println(weight);

			String contactType = request.getParameter(ATTRIBUTE_CONTACT_TYPE);
			String contactValue = request.getParameter(ATTRIBUTE_CONTACT_VALUE);

			if (contactType != null && !contactType.equals("") && contactValue != null && !contactValue.equals("")) {
				trainerContact = new TrainerContact();
				trainerContact.setType(contactType);
				trainerContact.setValue(contactValue);
				out.println(contactType + " , " + contactValue);
			}

			Integer qualificationYear = null;
			if (request.getParameter(ATTRIBUTE_QUALIFICATION_YEAR) != null && !request.getParameter(ATTRIBUTE_QUALIFICATION_YEAR).equals("")) {
				qualificationYear = Integer.parseInt(request.getParameter(ATTRIBUTE_QUALIFICATION_YEAR));
			}

			String qualificationName = request.getParameter(ATTRIBUTE_QUALIFICATION_NAME);
			String qualificationLevel = request.getParameter(ATTRIBUTE_QUALIFICATION_LEVEL);

			if (qualificationName != null && !qualificationName.equals("") && qualificationLevel != null && !qualificationLevel.equals("")
					&& qualificationYear != null) {
				trainerQualification = new TrainerQualification();
				trainerQualification.setName(qualificationName);
				trainerQualification.setLevel(qualificationLevel);
				trainerQualification.setYear(qualificationYear);
				out.println(qualificationName + " , " + qualificationLevel + " , " + qualificationYear);

			}

			facade.addTrainer(name, height, weight, trainerContact, trainerQualification);

			out.close();
		} catch (NumberFormatException e) {
			throw new ServletException("Bad parameter type");
		} catch (AdaptorException e) {
			e.printStackTrace();
		}

	}

}
