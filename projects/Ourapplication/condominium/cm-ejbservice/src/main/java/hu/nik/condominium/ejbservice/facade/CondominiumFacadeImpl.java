package hu.nik.condominium.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.nik.condominium.ejbservice.converter.CondominiumConverter;
import hu.nik.condominium.ejbservice.domain.CondominiumCriteria;
import hu.nik.condominium.ejbservice.domain.CondominiumStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.service.CondominiumService;

@Stateless(mappedName = "ejb/condominiumFacade")
public class CondominiumFacadeImpl implements CondominiumFacade {

	private static final Logger LOGGER = Logger.getLogger(CondominiumFacadeImpl.class);

	@EJB
	private CondominiumService service;

	@EJB
	private CondominiumConverter converter;

	@Override
	public CondominiumStub getCondonimium(Long id) throws FacadeException {

		try {
			final CondominiumStub stub = this.converter.to(this.service.read(id));
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
	public List<CondominiumStub> getCondominiums(CondominiumCriteria criteria) throws FacadeException {
		List<CondominiumStub> stubs = new ArrayList<>();
		try {
			stubs = this.converter.to(this.service.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Condonimiums by criteria (" + criteria + ") --> " + stubs.size() + " condonumium(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}
}
