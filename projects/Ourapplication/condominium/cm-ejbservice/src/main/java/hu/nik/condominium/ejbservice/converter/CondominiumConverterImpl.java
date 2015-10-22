package hu.nik.condominium.ejbservice.converter;

import hu.nik.condominium.ejbservice.domain.CondominiumStub;
import hu.nik.condominium.persistence.entity.Condominium;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CondominiumConverterImpl implements CondominiumConverter {

	@Override
	public CondominiumStub to(Condominium condominium) {
		return new CondominiumStub(condominium.getId(), condominium.getBuildYear(), condominium.getFloors(), condominium.getType().getName(),
				condominium.getLocation());
	}

	@Override
	public List<CondominiumStub> to(List<Condominium> condominiums) {
		final List<CondominiumStub> result = new ArrayList<CondominiumStub>();
		for (final Condominium condominium : condominiums) {
			result.add(this.to(condominium));
		}
		return result;
	}

}
