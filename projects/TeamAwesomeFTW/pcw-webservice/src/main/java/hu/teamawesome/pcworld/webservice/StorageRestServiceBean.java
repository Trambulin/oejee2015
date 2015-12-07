package hu.teamawesome.pcworld.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import hu.teamawesome.pcworld.ejbservice.domain.StorageStub;
import hu.teamawesome.pcworld.ejbservice.exception.AdaptorException;
import hu.teamawesome.pcworld.ejbservice.exception.FacadeException;
import hu.teamawesome.pcworld.ejbservice.facade.StorageFacade;

@Stateless
public class StorageRestServiceBean implements StorageRestService
{
	private static final Logger LOGGER = Logger.getLogger(StorageRestServiceBean.class);
	
	@EJB
	private StorageFacade facade;
	
	
	@Override
	public StorageStub getProduct(Long id) throws AdaptorException {
		LOGGER.info("Get product from Storage (" + id + ")");
		try {
			return this.facade.getProduct(id); // <----------------------string-----!!!!!
		} catch (AdaptorException e) {
			LOGGER.error(e, e);
		}
		return null;
	}
	
	
	@Override
	public List<StorageStub> getAllProduct() throws AdaptorException {
		LOGGER.info("Get all products from Storage");
		try {
			return this.facade.getProducts();
		} catch (AdaptorException e) {
			LOGGER.error(e, e);
		}
		return new ArrayList<>(); // return empty
	}
	
	
	@Override
	public void removeFromStorage(Long id) throws AdaptorException {
		LOGGER.info("Remove product from Storage (" + id + ")");
		this.facade.removeFromStorage(id);
	}
	
	
	@Override
	public Response optionsAll(String path) {
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	
	/*@Override
	public List<MarkDetailStub> getMarkDetails(String subject) throws AdaptorException {
		LOGGER.info("Get MarkDetails (" + subject + ")");
		return this.facade.getMarkDetails(subject);
	}

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
}


/*

@Stateless
public class StudentRestServiceBean implements StudentRestService {

	private static final Logger LOGGER = Logger.getLogger(StudentRestServiceBean.class);

	@EJB
	private StudentFacade facade;

	@Override
	public StudentStub getStudent(String neptun) throws AdaptorException {
		LOGGER.info("Get Student (" + neptun + ")");
		return this.facade.getStudent(neptun);
	}


	@Override
	public void removeStudent(String neptun) throws AdaptorException {
		LOGGER.info("Remove Student (" + neptun + ")");
		this.facade.removeStudent(neptun);
	}


}
*/