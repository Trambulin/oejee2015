package hu.nik.condominium.persistence.service;


import hu.nik.condominium.persistence.entity.CondominiumType;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.parameter.CondominiumTypeParameter;
import hu.nik.condominium.persistence.query.TypeQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CondominiumTypeServiceImpl implements CondominiumTypeService{

    private static final Logger LOGGER = Logger.getLogger(CondominiumTypeServiceImpl.class);

    @PersistenceContext(unitName = "cm-persistence-unit")
    private EntityManager entityManager;


    @Override
    public CondominiumType read(String name) throws PersistenceServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Get Type by name (" + name + ")");
        }
        CondominiumType result;
        try {
            result = this.entityManager.createNamedQuery(TypeQuery.GET_BY_NAME, CondominiumType.class).setParameter(CondominiumTypeParameter.NAME, name)
                    .getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Type by name (" + name + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }
    @Override
    public CondominiumType read(Long id) throws PersistenceServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Get Type by id (" + id + ")");
        }
        CondominiumType result;
        try {
            result = this.entityManager.createNamedQuery(TypeQuery.GET_BY_ID, CondominiumType.class).setParameter(CondominiumTypeParameter.ID, id)
                    .getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Type by id (" + id + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }
}
