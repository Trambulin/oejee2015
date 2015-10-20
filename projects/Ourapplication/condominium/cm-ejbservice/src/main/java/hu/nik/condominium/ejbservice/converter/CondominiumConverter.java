package hu.nik.condominium.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.nik.condominium.ejbservice.domain.CondominiumStub;
import hu.nik.condominium.persistence.entity.Condominium;

@Local
public interface CondominiumConverter {

	CondominiumStub to(Condominium condominium);

	List<CondominiumStub> to(List<Condominium> condominiums);

}
