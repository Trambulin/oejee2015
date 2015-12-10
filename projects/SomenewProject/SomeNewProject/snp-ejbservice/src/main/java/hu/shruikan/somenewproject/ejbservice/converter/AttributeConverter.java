package hu.shruikan.somenewproject.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.ejbservice.domain.AttributeStub;
import hu.shruikan.somenewproject.persistence.entity.Attribute;

@Local
public interface AttributeConverter {

	AttributeStub to(Attribute attribute);

	List<AttributeStub> to(List<Attribute> attributes);

}
