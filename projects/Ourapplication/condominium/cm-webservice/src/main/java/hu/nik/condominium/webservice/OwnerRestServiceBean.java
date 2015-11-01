package hu.nik.condominium.webservice;

import hu.nik.condominium.ejbservice.domain.OwnerStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.ejbservice.facade.OwnerFacade;
import hu.nik.condominium.ejbservice.util.ApplicationError;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OwnerRestServiceBean implements OwnerRestService {

    private static final Logger LOGGER = Logger.getLogger(OwnerRestServiceBean.class);

    @EJB
    private OwnerFacade facade;

    @Override
    public List<OwnerStub> getAllOwner() throws AdaptorException {
        LOGGER.info("Get all Owners");
        //return this.facade.getOwners();
        List<OwnerStub> result;
        try {
            result = this.facade.getOwners();
        } catch (FacadeException fc) {
            throw new AdaptorException(ApplicationError.UNEXPECTED, ":(");
        }
        return result;
    }
}
