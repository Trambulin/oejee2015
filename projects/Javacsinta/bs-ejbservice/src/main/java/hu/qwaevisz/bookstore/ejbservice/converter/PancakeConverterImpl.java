package hu.qwaevisz.bookstore.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;


import hu.qwaevisz.bookstore.ejbservice.domain.PancakeStub;

import hu.qwaevisz.bookstore.persistence.entity.Pancake;

@Stateless

public class PancakeConverterImpl implements PancakeConverter {

	@Override
	public PancakeStub to(Pancake pancake) {
		return new PancakeStub(pancake.getName(),pancake.getPrice(),pancake.getDescription());
	}

	@Override
	public List<PancakeStub> to(List<Pancake> pancakes) {
		final List<PancakeStub> result = new ArrayList<>();
		for (final Pancake pancake : pancakes) {
			result.add(this.to(pancake));
		}
		return result;
	}

}
