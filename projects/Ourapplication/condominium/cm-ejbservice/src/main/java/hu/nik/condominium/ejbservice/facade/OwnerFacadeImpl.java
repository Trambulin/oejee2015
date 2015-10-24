package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.converter.OwnerConverter;
import hu.nik.condominium.ejbservice.domain.OwnerStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.service.OwnerService;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(mappedName = "ejb/ownerFacade")
public class OwnerFacadeImpl implements  OwnerFacade{


    private static final Logger LOGGER = Logger.getLogger(OwnerFacadeImpl.class);

    @EJB
    private OwnerConverter converter;
    @EJB
    private OwnerService service;

    @Override
    public OwnerStub getOwner(Long id) throws FacadeException {
        try {
            final OwnerStub result= converter.to(service.read(id));
            if(LOGGER.isDebugEnabled())
                LOGGER.debug("Get Owner by id (" + id + ") --> " + result);
            return result;
        } catch (PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }
}
