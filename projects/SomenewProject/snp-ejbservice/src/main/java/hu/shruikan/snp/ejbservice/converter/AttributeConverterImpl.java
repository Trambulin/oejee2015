package hu.shruikan.snp.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.ejb.Stateless;

import hu.shruikan.snp.ejbservice.domain.AttributeStub;
import hu.shruikan.snp.persistence.entity.Attribute;

@Stateless
public class AttributeConverterImpl implements AttributeConverter 
{

	@Override
	public AttributeStub to(Attribute attribute) 
	{
		return new AttributeStub(attribute.getProductId(), attribute.getName(), attribute.getValue(), attribute.getCreateDate());
	}

	@Override
	public List<AttributeStub> to(List<Attribute> attributes) 
	{
		final List<AttributeStub> result = new ArrayList<>();
		for (final Attribute attribute : attributes) 
		{
			result.add(this.to(attribute));
		}
		return result;
	}
}
