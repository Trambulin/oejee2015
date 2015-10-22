package hu.nik.condominium.persistence.service;

import hu.nik.condominium.persistence.entity.Repair;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.query.RepairQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ReparServiceImpl implements ReparService {
    private static final Logger LOGGER = Logger.getLogger(ReparServiceImpl.class);

    @PersistenceContext(unitName = "cm-persistence-unit")
    private EntityManager entityManager;

    @Override
    public List<Repair> readAll() throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get Repairs");
        }
        List<Repair> result = null;
        try {
            result = this.entityManager.createNamedQuery(RepairQuery.GET_ALL, Repair.class).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Repair! " + e.getLocalizedMessage(), e);
        }
        return result;
    }
}
