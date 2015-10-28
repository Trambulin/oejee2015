package hu.sas.ejbservice.converter;

import java.util.List;

import hu.sas.ejbservice.domain.SportStub;
import hu.sas.persistance.enity.Sport ;

public interface SportConverter {
	SportStub to(Sport sport);
	List<SportStub> to(List<Sport> sports);
}
