package hu.nik.condominium.ejbservice.facade;


import hu.nik.condominium.ejbservice.converter.ReairConverter;
import hu.nik.condominium.ejbservice.domain.RepairCriteria;
import hu.nik.condominium.ejbservice.domain.RepairStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.service.ReparService;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
@Stateless(mappedName = "ejb/repairFacade")
public class RepairFacadeImpl implements RepairFacade {

    private static final Logger LOGGER = Logger.getLogger(RepairFacadeImpl.class);

    @EJB
    private ReairConverter converter;
    @EJB
    private ReparService service;

    @Override
    public List<RepairStub> getRepairs(RepairCriteria criteria) throws FacadeException {
        List<RepairStub> stubs;
        try {
            stubs = this.converter.to(this.service.readAll());
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get Repairs by criteria (" + criteria + ") --> " + stubs.size() + " repairs(s)");
            }
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
        return stubs;
    }
}
