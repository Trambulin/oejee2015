package hu.shruikan.somenewproject.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.shruikan.somenewproject.ejbservice.domain.AttributeStub;
import hu.shruikan.somenewproject.persistence.entity.Attribute;

@Stateless
public class AttributeConverterImpl implements AttributeConverter {

	@Override
	public AttributeStub to(Attribute attribute) {
		AttributeStub stub = null;
		if (attribute != null) {
			stub = new AttributeStub(attribute.getName(), attribute.getValue());
		}
		return stub;
	}

	@Override
	public List<AttributeStub> to(final List<Attribute> attributes) {
		final List<AttributeStub> stubs = new ArrayList<>();
		for (final Attribute attribute : attributes) {
			stubs.add(this.to(attribute));
		}
		return stubs;
	}

}
