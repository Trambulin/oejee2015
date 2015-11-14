package hu.nik.condominium.persistence.service;


import hu.nik.condominium.persistence.entity.Notification;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;

import java.util.List;

public interface NotificationService {
    Notification read(Long id) throws PersistenceServiceException;
    List<Notification> readAll()throws  PersistenceServiceException;
}
