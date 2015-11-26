package hu.nik.condominium.persistence.service;

import hu.nik.condominium.persistence.entity.CondominiumOwner;
import hu.nik.condominium.persistence.entity.Notification;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.parameter.NotificationParameter;
import hu.nik.condominium.persistence.query.NotificationQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class NotificationServiceImpl implements NotificationService{
    private static final Logger LOGGER = Logger.getLogger(NotificationServiceImpl.class);

    @PersistenceContext(unitName = "cm-persistence-unit")
    private EntityManager entityManager;

    @EJB
    private CondominiumOwnerService condominiumOwnerService;

    @Override
    public Notification read(Long id) throws PersistenceServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Get Notification by id (" + id + ")");
        }
        Notification result;
        try {
            result = this.entityManager.createNamedQuery(NotificationQuery.GET_BY_ID, Notification.class).setParameter(NotificationParameter.ID, id)
                    .getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Notification by id (" + id + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public List<Notification> readAll() throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get Notifications");
        }
        List<Notification> result = null;
        try {
            result = this.entityManager.createNamedQuery(NotificationQuery.GET_ALL, Notification.class).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Notifications! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public List<Notification> readByOwner(Long ownerId) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get Notifications by ownerid: "+ownerId);
        }
        List<Notification> result = null;
        try {
            result = this.entityManager.createNamedQuery(NotificationQuery.GET_BY_OWNER_ID, Notification.class).setParameter(NotificationParameter.OWNERID,ownerId).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Notifications! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public void create(Long cOwnerid, String message, Date date) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            //LOGGER.debug("Create a new Notification (puller: " + puller + ", prizePool: " + prizePool + ", numbers: " + Arrays.toString(numbers) + ")");
            LOGGER.debug("Create a new Notification: condominiumOwnerId"+cOwnerid+", message: "+message+", date"+date.toString());
        }
        try {
            CondominiumOwner condominiumOwner=condominiumOwnerService.read(cOwnerid);
            final Notification notification = new Notification(condominiumOwner,message,date);
            this.entityManager.persist(notification);
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Notifications! " + e.getLocalizedMessage(), e);
        }
    }
}
