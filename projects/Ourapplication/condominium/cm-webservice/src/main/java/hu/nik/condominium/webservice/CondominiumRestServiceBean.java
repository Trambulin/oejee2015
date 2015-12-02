package hu.nik.condominium.webservice;

import hu.nik.condominium.ejbservice.domain.CondominiumCriteria;
import hu.nik.condominium.ejbservice.domain.CondominiumInputStub;
import hu.nik.condominium.ejbservice.domain.CondominiumStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;
import hu.nik.condominium.ejbservice.facade.CondominiumFacade;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CondominiumRestServiceBean implements CondominiumRestService{

    private static final Logger LOGGER = Logger.getLogger(CondominiumRestServiceBean.class);

    @EJB
    CondominiumFacade facade;
    @Override
    public CondominiumStub addCondominium(CondominiumInputStub stub) throws AdaptorException {
        LOGGER.info("Add Condominium (" + stub + ")");
        return this.facade.addCondominium(stub.getLocation(), stub.getFloors(), stub.getBuildYear(), stub.getType());
    }

    @Override
    public CondominiumStub getMatchingCondominium(CondominiumCriteria criteria) throws AdaptorException {

        return this.facade.getMatchingCondominium(criteria.getCondominiumTypeNameTerm(),
                criteria.getMinimumFloors(),criteria.getMaximumFloors());
    }
}
