package hu.nik.condominium.persistence.service;


import hu.nik.condominium.persistence.entity.Notification;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;

import java.sql.Date;
import java.util.List;

public interface NotificationService {
    Notification read(Long id) throws PersistenceServiceException;
    List<Notification> readAll()throws  PersistenceServiceException;
    List<Notification> readByOwner(Long ownerId)throws  PersistenceServiceException;
    void create(Long cOwnerid, String message,Date date) throws  PersistenceServiceException;
}
