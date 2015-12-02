package hu.marcibbx.JEEzusom.webservice;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;

import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;
import hu.marcibbx.JEEzusom.ejbservice.facade.AccountFacade;
import hu.marcibbx.JEEzusom.ejbservice.facade.CharacterBaseFacade;

@Stateless
public class AccountRestServiceBean implements AccountRestService {

	private static final Logger LOGGER = Logger.getLogger(AccountRestServiceBean.class);

	@EJB
	private AccountFacade facade;
	
	
	@EJB
	private CharacterBaseFacade characterBaseFacade;

	
	@Override
	public List<CharacterBaseStub> getCharacterBases(Long accountId) throws AdaptorException {
		LOGGER.info("Get CharacterBases (" + accountId + ")");
		return this.characterBaseFacade.getCharacterBases(accountId);
	}
/*
	@Override
	public MarkStub addMark(MarkInputStub stub) throws AdaptorException {
		LOGGER.info("Add Mark (" + stub + ")");
		return this.facade.addMark(stub.getSubject(), stub.getNeptun(), stub.getGrade().getValue(), stub.getNote());
	}

	@Override
	public MarkStub getMatchingMark(String studentNeptun, MarkCriteria criteria) throws AdaptorException {
		LOGGER.info("Get first matching Mark (studentNeptun: " + studentNeptun + ", criteria: " + criteria + ")");
		final MarkStub stub = new MarkStub(new SubjectStub("subject1", new TeacherStub("teacher1", "teacher1neptun"), "subject1description"), 2, "note1",
				new Date());
		LOGGER.info("MarkStub: " + stub);
		return this.facade.getMatchingMark(studentNeptun, criteria.getSubjectNameTerm(), criteria.getMinimumGrade(), criteria.getMaximumGrade());
	}
*/
	@Override
	public Response optionsAll(String path) {
		return Response.status(Response.Status.NO_CONTENT).build();
	}

}
