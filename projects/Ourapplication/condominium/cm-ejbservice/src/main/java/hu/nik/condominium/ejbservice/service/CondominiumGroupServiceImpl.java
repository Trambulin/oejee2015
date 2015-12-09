package hu.nik.condominium.ejbservice.service;

import hu.nik.condominium.ejbservice.domain.CondominiumGroup;
import hu.nik.condominium.ejbservice.domain.CondominiumSoapStub;
import hu.nik.condominium.ejbservice.exception.ServiceException;
import hu.nik.condominium.persistence.service.CondominiumService;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.List;

@Stateful(mappedName = "ejb/condominiumService")
public class CondominiumGroupServiceImpl implements CondominiumGroupService {

    private static final Logger LOGGER = Logger.getLogger(CondominiumGroupServiceImpl.class);

    private CondominiumGroup condominiumGroup;

    @EJB
    private CondominiumService condominiumService;

    @PostConstruct
    public void setup() {
        this.condominiumGroup = new CondominiumGroup();
    }

    @Override
    public void addItem(CondominiumSoapStub condominiumSoapStub) throws ServiceException {
        LOGGER.debug("Add Condominium (" + condominiumSoapStub + ") to " + this.condominiumGroup);
        this.condominiumGroup.add(condominiumSoapStub);
    }

    @Override
    public void setIdentifier(String identifier) throws ServiceException {
        LOGGER.debug("Set the identifier (" + identifier + ") for " + this.condominiumGroup);
        if (!this.condominiumGroup.hasIdentifier()) {
            this.condominiumGroup.setIdentifier(identifier);
        } else {
            throw new ServiceException(42, "CondominiumGroup already has an identifier (" + this.condominiumGroup.getIdentifier() + ").");
        }
    }

    @Override
    public String getIdentifier() throws ServiceException {
        LOGGER.debug("Get the identifier of the " + this.condominiumGroup);
        return this.condominiumGroup.getIdentifier();
    }

    @Override
    public void saveAll() throws ServiceException {
        final List<CondominiumSoapStub> stubs = condominiumGroup.getCondominiumStubs();
        if (stubs.size() == 0) {
            throw new ServiceException(42, "Empty list! Add some items and after save them!");
        }
        //TODO: save entities
        throw new ServiceException(42, "Missing implementation :( ");
    }

    @Override
    public CondominiumGroup getItems() throws ServiceException {
        LOGGER.debug("Get " + this.condominiumGroup);
        return condominiumGroup;
    }

    @Remove
    public void remove() {
        this.condominiumGroup = null;
    }
}
