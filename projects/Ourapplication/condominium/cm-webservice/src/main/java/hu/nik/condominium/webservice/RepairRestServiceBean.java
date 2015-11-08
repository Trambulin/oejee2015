package hu.nik.condominium.webservice;

import hu.nik.condominium.ejbservice.domain.RepairCondominiumStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.ejbservice.facade.RepairCondominiumFacade;
import hu.nik.condominium.ejbservice.util.ApplicationError;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RepairRestServiceBean implements RepairRestService {
    private static final Logger LOGGER = Logger.getLogger(RepairRestServiceBean.class);
    @EJB
    private RepairCondominiumFacade facade;

    @Override
    public List<RepairCondominiumStub> getAllRepairAvgOfCondominiums() throws AdaptorException {
        LOGGER.info("Get Avg repairs group by condominiums");
        List<RepairCondominiumStub> result;
        try {
            result = this.facade.getAvgOfRepairsGroupByCondominium();
        } catch (FacadeException fc) {
            throw new AdaptorException(ApplicationError.UNEXPECTED, ":(");
        }
        return result;
    }
}
