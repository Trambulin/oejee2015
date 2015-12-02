package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.converter.CondominiumConverter;
import hu.nik.condominium.ejbservice.domain.CondominiumCriteria;
import hu.nik.condominium.ejbservice.domain.CondominiumStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.ejbservice.util.ApplicationError;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.service.CondominiumService;
import hu.nik.condominium.persistence.service.CondominiumTypeService;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Date;
import java.util.List;

@Stateless(mappedName = "ejb/condominiumFacade")
public class CondominiumFacadeImpl implements CondominiumFacade {

	private static final Logger LOGGER = Logger.getLogger(CondominiumFacadeImpl.class);

	@EJB
	private CondominiumService condominiumService;

	@EJB
	private CondominiumConverter converter;

	@EJB
	private CondominiumTypeService condominiumTypeService;
	@Override
	public CondominiumStub getCondonimium(Long id) throws FacadeException {

		try {
			final CondominiumStub stub = this.converter.to(this.condominiumService.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Condonomium by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public CondominiumStub addCondominium(String location, int floors, String buildYear, String type) throws AdaptorException {
		try {

			final Long condominiumType=this.condominiumTypeService.read(type).getId();
			final Date date=Date.valueOf(buildYear);
			final CondominiumStub condominiumStub = this.converter.to(this.condominiumService.create(location, floors, date, condominiumType));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add a new Condominium (location: " + location + ", floors: " + floors + ", buildyear: " + buildYear + ", type: " + type + ") --> " + condominiumStub);
			}
			return condominiumStub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}

	}

	@Override
	public List<CondominiumStub> getCondominiums(CondominiumCriteria criteria) throws FacadeException {
		List<CondominiumStub> stubs;
		try {
			stubs = this.converter.to(this.condominiumService.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Condonimiums by criteria (" + criteria + ") --> " + stubs.size() + " condonumium(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public CondominiumStub getMatchingCondominium(String type, int minimumFloors, int maximumFloors) throws AdaptorException {
		CondominiumStub stub = null;

		try{
			stub = this.converter.to(this.condominiumService.read(type,minimumFloors,maximumFloors));
		}catch (PersistenceServiceException e)
		{
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}

		return	stub;
	}
}
