package hu.sas.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import hu.sas.ejbservice.domain.MealStub;
import hu.sas.persistance.entity.Meal;

public class MealConverterImpl implements MealConverter {

	@Override
	public MealStub to(Meal meal) {
		return new MealStub(meal.getMealTime(),meal.getMealContent(),meal.getFullness());
	}

	@Override
	public List<MealStub> to(List<Meal> meals) {
		final List<MealStub> result = new ArrayList<>();
		for (final Meal meal : meals) {
			result.add(this.to(meal));
		}
		return result;
	}
	
}
