package hu.sas.ejbservice.converter;

import java.util.List;

import hu.sas.ejbservice.domain.MealStub;
import hu.sas.persistance.enity.Meal;

public interface MealConverter {
	MealStub to(Meal meal);
	
	List<MealStub> to(List<Meal> meals);
}
