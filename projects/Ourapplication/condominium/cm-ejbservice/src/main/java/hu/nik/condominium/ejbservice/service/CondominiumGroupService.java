package hu.nik.condominium.ejbservice.service;

import hu.nik.condominium.ejbservice.domain.CondominiumGroup;
import hu.nik.condominium.ejbservice.domain.CondominiumSoapStub;
import hu.nik.condominium.ejbservice.exception.ServiceException;

import javax.ejb.Local;

@Local
public interface CondominiumGroupService {
    void addItem(CondominiumSoapStub condominiumStub) throws ServiceException;
    void setIdentifier(String identifier) throws ServiceException;
    CondominiumGroup getItems() throws  ServiceException;
    String getIdentifier() throws ServiceException;
    void saveAll() throws  ServiceException;
}
