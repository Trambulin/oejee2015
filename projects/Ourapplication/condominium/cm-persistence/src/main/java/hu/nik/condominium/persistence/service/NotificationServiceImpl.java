package hu.nik.condominium.persistence.service;

import hu.nik.condominium.persistence.entity.Notification;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.parameter.NotificationParameter;
import hu.nik.condominium.persistence.query.NotificationQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class NotificationServiceImpl implements NotificationService{
    private static final Logger LOGGER = Logger.getLogger(NotificationServiceImpl.class);

    @PersistenceContext(unitName = "cm-persistence-unit")
    private EntityManager entityManager;

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
}
