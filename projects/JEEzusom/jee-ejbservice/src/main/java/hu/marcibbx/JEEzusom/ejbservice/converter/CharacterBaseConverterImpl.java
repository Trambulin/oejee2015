package hu.marcibbx.JEEzusom.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.persistence.entity.CharacterBase;

@Stateless
public class CharacterBaseConverterImpl implements CharacterBaseConverter {


	@Override
	public CharacterBaseStub to(final CharacterBase characterBase) {
		final CharacterBaseStub characterBaseStub = new CharacterBaseStub(characterBase.getName(), characterBase.getRaceId(), characterBase.getIsMale(), characterBase.getAccountId());
		return characterBaseStub;
	}

	@Override
	public List<CharacterBaseStub> to(final List<CharacterBase> characterBases) {
		final List<CharacterBaseStub> stubs = new ArrayList<>();
		for (final CharacterBase characterBase : characterBases) {
			stubs.add(this.to(characterBase));
		}
		return stubs;
	}

}
