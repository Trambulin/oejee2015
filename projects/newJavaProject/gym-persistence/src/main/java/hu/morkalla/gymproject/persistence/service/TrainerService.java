package hu.morkalla.gymproject.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.morkalla.gymproject.persistence.entity.Trainer;
import hu.morkalla.gymproject.persistence.entity.TrainerContact;
import hu.morkalla.gymproject.persistence.entity.TrainerQualification;
import hu.morkalla.gymproject.persistence.exception.PersistenceServiceException;

@Local
public interface TrainerService {

	Trainer meet(Long id) throws PersistenceServiceException;

	Trainer meet(String name) throws PersistenceServiceException;

	List<Trainer> meetAll() throws PersistenceServiceException;

	Trainer create(String name, Integer height, Integer weight, TrainerContact trainerContact, TrainerQualification trainerQualification)
			throws PersistenceServiceException;

}
