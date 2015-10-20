package hu.nik.condominium.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.nik.condominium.ejbservice.domain.CondominiumStub;
import hu.nik.condominium.persistence.entity.Condominium;

@Stateless
public class CondominiumConverterImpl implements CondominiumConverter {

	@Override
	public CondominiumStub to(Condominium condominium) {
		return new CondominiumStub(condominium.getId(), condominium.getBuildYear(), condominium.getFloors());
	}

	@Override
	public List<CondominiumStub> to(List<Condominium> condominiums) {
		final List<CondominiumStub> result = new ArrayList<>();
		for (final Condominium condominium : condominiums) {
			result.add(this.to(condominium));
		}
		return result;
	}

}
