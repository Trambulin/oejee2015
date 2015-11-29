package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.converter.NotificationConverter;
import hu.nik.condominium.ejbservice.domain.NotificationStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.ejbservice.holder.CondominiumStateHolder;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.service.NotificationService;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Date;
import java.util.List;

@Stateless(mappedName = "ejb/notificationFacade")
public class NotificationFacadeImpl implements  NotificationFacade{

    private static final Logger LOGGER = Logger.getLogger(NotificationFacadeImpl.class);

    @EJB
    private NotificationConverter converter;

    @EJB
    private NotificationService service;

    @EJB
    private CondominiumStateHolder stateHolder;

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

    @Override
    public List<NotificationStub> getByOwnerId(Long ownerid) throws FacadeException {
        List<NotificationStub> stubs;
        try {
            stubs = this.converter.to(this.service.readByOwner(ownerid));
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
    public void createNotification(Long cOwnerId, String message,Date date) throws FacadeException {
        try {
            if(this.stateHolder.getEnabled()){
                 this.service.create(cOwnerId,message,date);
            }
            else{
                LOGGER.info("REJECTED NOTIFICATION! cOwnerId: "+cOwnerId+",message: "+message+", date: "+date);
            }
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            //throw new AdaptorException(e.getLocalizedMessage());
        }
    }
}
