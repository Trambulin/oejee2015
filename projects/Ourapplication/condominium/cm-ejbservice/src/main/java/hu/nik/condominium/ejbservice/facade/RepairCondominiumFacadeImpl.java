package hu.nik.condominium.ejbservice.facade;


import hu.nik.condominium.ejbservice.converter.RepairCondominiumConverter;
import hu.nik.condominium.ejbservice.domain.RepairCondominiumStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.service.ReparService;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(mappedName = "ejb/repairCondominiumFacade")
public class RepairCondominiumFacadeImpl implements RepairCondominiumFacade {

    private static final Logger LOGGER = Logger.getLogger(RepairFacadeImpl.class);

    @EJB
    private RepairCondominiumConverter converter;
    @EJB
    private ReparService service;


    @Override
    public List<RepairCondominiumStub> getAvgOfRepairsGroupByCondominium() throws FacadeException {
        List<RepairCondominiumStub> stubs;
        try {
            stubs = this.converter.to(this.service.getAvgGbyCondominium());
            if (LOGGER.isDebugEnabled()) {
                //LOGGER.debug("Get Condonimiums by criteria (" + criteria + ") --> " + stubs.size() + " condonumium(s)");
            }
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
        return stubs;
    }
}
