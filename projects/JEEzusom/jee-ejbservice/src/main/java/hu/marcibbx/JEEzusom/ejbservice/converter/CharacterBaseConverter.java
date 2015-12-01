package hu.marcibbx.JEEzusom.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.persistence.entity.CharacterBase;

@Local
public interface CharacterBaseConverter {

	CharacterBaseStub to(CharacterBase characterBase);

	List<CharacterBaseStub> to(List<CharacterBase> characterBases);

}
