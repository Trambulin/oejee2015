package hu.morkalla.gymproject.ejbservice.facade;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hu.morkalla.gymproject.ejbservice.converter.TrainerConverter;
import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.persistence.entity.Trainer;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;
import hu.morkalla.gymproject.persistence.service.TrainerService;

public class TrainerFacadeImplTest {

	private static final String TRAINER_NAME = "Kiss Imre";
	private static final Long TRAINER_ID = 42L;

	@InjectMocks
	private TrainerFacadeImpl facade;

	@Mock
	private TrainerService trainerService;

	@Mock
	private TrainerConverter trainerConverter;

	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createListOfTrainerDetailsFromSubjectName() throws AdaptorException, PersistenceServiceException {
		Trainer trainer = Mockito.mock(Trainer.class);
		Mockito.when(this.trainerService.meet(TRAINER_NAME)).thenReturn(trainer);
		Mockito.when(trainer.getId()).thenReturn(TRAINER_ID);

		Assert.assertEquals(trainer.getId(), TRAINER_ID);
	}

}
