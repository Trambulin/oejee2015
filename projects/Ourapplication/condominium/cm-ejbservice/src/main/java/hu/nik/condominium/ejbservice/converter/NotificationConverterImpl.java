package hu.nik.condominium.ejbservice.converter;

import hu.nik.condominium.ejbservice.domain.NotificationStub;
import hu.nik.condominium.persistence.entity.Notification;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class NotificationConverterImpl implements NotificationConverter{

    @Override
    public NotificationStub to(Notification notification) {
       return new NotificationStub(notification.getId(),notification.getMessage(), notification.getDate(), notification.getAnswer(),
               notification.getCompleted(),notification.getCondominiumOwner().getCondominium().getLocation(),notification.getCondominiumOwner().getStairs(),notification.getCondominiumOwner().getDoors());
    }

    @Override
    public List<NotificationStub> to(List<Notification> notifications) {
        List<NotificationStub> resultList=new ArrayList<>();
        for(Notification nf:notifications)
            resultList.add(to(nf));
        return resultList;
    }
}
