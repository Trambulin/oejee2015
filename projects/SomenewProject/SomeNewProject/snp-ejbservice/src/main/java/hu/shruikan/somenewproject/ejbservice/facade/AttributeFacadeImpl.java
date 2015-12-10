package hu.shruikan.somenewproject.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.shruikan.somenewproject.ejbservice.converter.AttributeConverter;
import hu.shruikan.somenewproject.ejbservice.domain.AttributeStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;
import hu.shruikan.somenewproject.ejbservice.util.ApplicationError;
import hu.shruikan.somenewproject.persistence.exception.PersistenceServiceException;
import hu.shruikan.somenewproject.persistence.service.AttributeService;

@Stateless(mappedName = "ejb/attributeFacade")
public class AttributeFacadeImpl implements AttributeFacade {

	private static final Logger LOGGER = Logger.getLogger(AttributeFacadeImpl.class);

	@EJB
	private AttributeService attributeService;

	@EJB
	private AttributeConverter converter;

	@Override
	public AttributeStub getAttribute(Long id) throws AdaptorException {
		try {
			final AttributeStub stub = this.converter.to(this.attributeService.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Attribute (id: " + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}


}
