package hu.nik.condominium.persistence.service;

import hu.nik.condominium.persistence.entity.CondominiumOwner;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.parameter.CondominiumOwnerParameter;
import hu.nik.condominium.persistence.query.CondominiumOwnerQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CondominiumOwnerServiceImpl implements CondominiumOwnerService {

    private static final Logger LOGGER = Logger.getLogger(NotificationServiceImpl.class);

    @PersistenceContext(unitName = "cm-persistence-unit")
    private EntityManager entityManager;

    @Override
    public CondominiumOwner read(Long id) throws PersistenceServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Get CondominiumOwner entity by id (" + id + ")");
        }
        CondominiumOwner result;
        try {
            result = this.entityManager.createNamedQuery(CondominiumOwnerQuery.GET_BY_ID, CondominiumOwner.class).setParameter(CondominiumOwnerParameter.ID, id)
                    .getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching CondominiumOwner entity by id (" + id + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }
}
