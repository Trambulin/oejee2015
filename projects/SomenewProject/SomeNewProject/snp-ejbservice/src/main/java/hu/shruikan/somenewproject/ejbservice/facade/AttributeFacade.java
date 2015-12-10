package hu.shruikan.somenewproject.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.shruikan.somenewproject.ejbservice.domain.AttributeStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;

@Local
public interface AttributeFacade {

	AttributeStub getAttribute(Long id) throws AdaptorException;

}
