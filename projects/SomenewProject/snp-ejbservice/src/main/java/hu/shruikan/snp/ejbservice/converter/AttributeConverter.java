package hu.shruikan.snp.ejbservice.converter;

import java.util.List;
import java.util.Date;

import javax.ejb.Local;

import hu.shruikan.snp.ejbservice.domain.AttributeStub;
import hu.shruikan.snp.persistence.entity.Attribute;

@Local
public interface AttributeConverter
{
	AttributeStub to(Attribute attribute);
	
	List<AttributeStub> to(List<Attribute> attributes);
}