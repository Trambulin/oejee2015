package hu.sas.ejbservice.converter;

import java.util.List;

import hu.sas.ejbservice.domain.FeelStub;
import hu.sas.persistance.enity.Feel;

public interface FeelConverter {
	FeelStub to(Feel feel);
	List<FeelStub> to(List<Feel> feels);
}
