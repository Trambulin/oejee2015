package hu.nik.condominium.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.nik.condominium.persistence.entity.User;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.parameter.UserParameter;
import hu.nik.condominium.persistence.query.UserQuery;

@Stateless(mappedName = "ejb/groupService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	
    @PersistenceContext(unitName = "cm-persistence-unit")
    private EntityManager entityManager;
    
	@Override
	public User read(String login) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Get User by login (" + login + ")");
        }
        User result;
        try {
            result = this.entityManager.createNamedQuery(UserQuery.GET_BY_LOGIN, User.class).setParameter(UserParameter.LOGIN, login).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching User by login (" + login + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
	}

	@Override
	public List<User> readAll() throws PersistenceServiceException {
		  if(LOGGER.isDebugEnabled()){
	            LOGGER.debug("Get Users");
	        }
	        List<User> result = null;
	        try {
	            result = this.entityManager.createNamedQuery(UserQuery.GET_ALL, User.class).getResultList();
	        } catch (final Exception e) {
	            throw new PersistenceServiceException("Unknown error when fetching USERS" + e.getLocalizedMessage(), e);
	        }
	        return result;
	}

}
