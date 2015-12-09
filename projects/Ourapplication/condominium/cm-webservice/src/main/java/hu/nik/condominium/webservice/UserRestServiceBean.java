package hu.nik.condominium.webservice;

import hu.nik.condominium.ejbservice.domain.UserStub;
import hu.nik.condominium.ejbservice.exception.AdaptorException;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.ejbservice.facade.UserFacade;
import hu.nik.condominium.ejbservice.util.ApplicationError;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Hidvégi Péter on 2015.12.02..
 */
@Stateless
public class UserRestServiceBean implements UserRestService {

    @EJB
    private UserFacade facade;

    @Override
    public UserStub getUser(String username) throws AdaptorException {
        UserStub result;
        try {
            result = this.facade.getUser(username);
        } catch (FacadeException fc) {
            throw new AdaptorException(ApplicationError.UNEXPECTED, ":(");
        }

        return result;
    }
}
