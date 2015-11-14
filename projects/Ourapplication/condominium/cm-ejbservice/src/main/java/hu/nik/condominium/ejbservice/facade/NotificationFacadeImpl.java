package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.converter.NotificationConverter;
import hu.nik.condominium.ejbservice.domain.NotificationStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.service.NotificationService;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(mappedName = "ejb/notificationFacade")
public class NotificationFacadeImpl implements  NotificationFacade{

    private static final Logger LOGGER = Logger.getLogger(NotificationFacadeImpl.class);

    @EJB
    private NotificationConverter converter;

    @EJB
    private NotificationService service;
    @Override
    public List<NotificationStub> getAll() throws FacadeException{
        List<NotificationStub> stubs;
        try {
            stubs = this.converter.to(this.service.readAll());
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get Notifications ");
            }
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
        return stubs;
    }

    @Override
    public NotificationStub getById(Long id) throws FacadeException{
        try {
            final NotificationStub stub = this.converter.to(this.service.read(id));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get Notification by id (" + id + ") --> " + stub);
            }
            return stub;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }
}
