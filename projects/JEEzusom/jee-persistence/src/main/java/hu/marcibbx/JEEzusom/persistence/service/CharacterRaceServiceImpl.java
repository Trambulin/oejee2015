package hu.marcibbx.JEEzusom.persistence.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.marcibbx.JEEzusom.persistence.entity.CharacterRace;
import hu.marcibbx.JEEzusom.persistence.exception.PersistenceServiceException;
import hu.marcibbx.JEEzusom.persistence.parameter.CharacterRaceParameter;

import hu.marcibbx.JEEzusom.persistence.query.CharacterRaceQuery;


@Stateless(mappedName = "ejb/characterRaceService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CharacterRaceServiceImpl implements CharacterRaceService {

	private static final Logger LOGGER = Logger.getLogger(CharacterRaceServiceImpl.class);

	@PersistenceContext(unitName = "jee-persistence-unit")
	private EntityManager entityManager;
/*
	@EJB
	private StudentService studentService;

	@EJB
	private SubjectService subjectService;

	@Override
	public int count(String studentNeptun) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Count Student's marks by student's neptun (" + studentNeptun + ")");
		}
		try {
			return this.entityManager.createNamedQuery(MarkQuery.COUNT_BY_STUDENT_NEPTUN, Long.class).setParameter(MarkParameter.STUDENT_NEPTUN, studentNeptun)
					.getSingleResult().intValue();
		} catch (final Exception e) {
			throw new PersistenceServiceException(
					"Unknown error during counting Student's mark by student's neptun (" + studentNeptun + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Mark create(Long studentId, Long subjectId, Integer grade, String note) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add Mark (studentId: " + studentId + ", subjectId: " + subjectId + ", grade: " + grade + ", note: " + note + ")");
		}
		try {
			final Student student = this.studentService.read(studentId);
			final Subject subject = this.subjectService.read(subjectId);
			Mark mark = new Mark(student, subject, grade, note);
			mark = this.entityManager.merge(mark);
			this.entityManager.flush();
			return mark;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during merging SubscriberGroup (studentId: " + studentId + ", subjectId: " + subjectId
					+ ", grade: " + grade + ", note: " + note + ")! " + e.getLocalizedMessage(), e);
		}
	}
*/
	@Override
	public CharacterRace read(Long raceId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get all CharacterRace by race id (" + raceId + ")");
		}
		CharacterRace result = null;
		try {
			result = this.entityManager.createNamedQuery(CharacterRaceQuery.GET_BY_ID, CharacterRace.class)
					.setParameter(CharacterRaceParameter.RACE_ID, raceId).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching CharacterRaces! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
/*
	@Override
	public Mark read(String studentNeptun, String subjectNameTerm, Integer minimumGrade, Integer maximumGrade) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get first matching Mark by criteria (studentNeptun: " + studentNeptun + ", subjectNameTerm: " + subjectNameTerm + ", minimumGrade: "
					+ minimumGrade + ", maximumGrade: " + maximumGrade + ")");
		}
		Mark result = null;
		try {
			List<Mark> results = this.entityManager.createNamedQuery(MarkQuery.READ_BY_FILTER, Mark.class)
					.setParameter(MarkParameter.STUDENT_NEPTUN, studentNeptun).setParameter(MarkParameter.SUBJECT_NAME_TERM, "%" + subjectNameTerm + "%")
					.setParameter(MarkParameter.MIN_GRADE, minimumGrade).setParameter(MarkParameter.MAX_GRADE, maximumGrade).getResultList();
			if (results.size() > 0) {
				result = results.get(0);
			}
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching matching Mark (studentNeptun: " + studentNeptun + ", subjectNameTerm: "
					+ subjectNameTerm + ", minimumGrade: " + minimumGrade + ", maximumGrade: " + maximumGrade + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
*/
}
