package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.domain.NotificationStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NotificationFacade {
    List<NotificationStub> getAll() throws FacadeException;
    NotificationStub getById(Long id) throws FacadeException;
}
