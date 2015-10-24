package hu.nik.condominium.persistence.service;

import hu.nik.condominium.persistence.entity.Owner;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.parameter.OwnerParameter;
import hu.nik.condominium.persistence.query.OwnerQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class OwnerServiceImpl implements OwnerService {

    private static final Logger LOGGER = Logger.getLogger(OwnerServiceImpl.class);

    @PersistenceContext(unitName = "cm-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Owner read(Long id) throws PersistenceServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Get Owner by id (" + id + ")");
        }
        Owner result = null;
        try {
            result = this.entityManager.createNamedQuery(OwnerQuery.GET_BY_ID, Owner.class).setParameter(OwnerParameter.ID, id)
                    .getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Owner by id (" + id + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }
}
