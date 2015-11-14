package hu.nik.condominium.webservice;

import hu.nik.condominium.ejbservice.domain.NotificationStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.ejbservice.facade.NotificationFacade;
import hu.nik.condominium.ejbservice.util.ApplicationError;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class NotificationRestServiceBean implements NotificationRestService {
    private static final Logger LOGGER = Logger.getLogger(NotificationRestServiceBean.class);
    @EJB
    private NotificationFacade facade;

    @Override
    public List<NotificationStub> getNotificationByOwner(String ownerid) throws AdaptorException {
        LOGGER.info("Get notifications of ownerid="+ownerid);
        //return this.facade.getOwners();
        List<NotificationStub> result;
        try {
            result = this.facade.getByOwnerId(Long.valueOf(ownerid));
        } catch (FacadeException fc) {
            throw new AdaptorException(ApplicationError.UNEXPECTED, ":(");
        }
        return result;
    }
}
