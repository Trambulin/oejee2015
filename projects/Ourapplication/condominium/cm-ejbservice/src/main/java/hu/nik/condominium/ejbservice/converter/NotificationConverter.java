package hu.nik.condominium.ejbservice.converter;

import hu.nik.condominium.ejbservice.domain.NotificationStub;
import hu.nik.condominium.persistence.entity.Notification;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NotificationConverter {
    NotificationStub to(Notification notification);

    List<NotificationStub> to(List<Notification> notifications);
}
