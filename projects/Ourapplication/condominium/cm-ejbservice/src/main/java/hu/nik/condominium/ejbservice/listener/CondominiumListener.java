package hu.nik.condominium.ejbservice.listener;

import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.ejbservice.facade.NotificationFacade;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.*;
import java.sql.Date;

@MessageDriven(name = "CondominiumListener", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "condominiumqueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class CondominiumListener implements MessageListener {

	private static final Logger LOGGER = Logger.getLogger(CondominiumListener.class);

	@EJB
	private NotificationFacade facade;

	@PostConstruct
	public void initialize() {
		LOGGER.info("Notification Listener created...");
	}

	@Override
	public void onMessage(final Message message) {
		LOGGER.info("onMessage Called with message: "+message);
		try {
			if (LOGGER.isDebugEnabled()) {
				final Queue destination = (Queue) message.getJMSDestination();
				final String queueName = destination.getQueueName();
				LOGGER.debug("New JMS message arrived into " + queueName + " queue (correlation id: " + message.getJMSCorrelationID() + ")");
			}

			if (message instanceof TextMessage) {
				final TextMessage textMessage = (TextMessage) message;
				String content = textMessage.getText();
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Received message: " + content);
				}
				String[] res=  content.split("\\|");
				Long cOwnerId=Long.valueOf(res[0]);
				this.facade.createNotification(cOwnerId,res[1],new Date(Long.valueOf(res[2])));
			} else {
				LOGGER.error("Received message is not a TextMessage (" + message + ")");
			}
		} catch (final JMSException | NumberFormatException e) {
			LOGGER.error(e, e);
		} catch (FacadeException e) {
			e.printStackTrace();
		}
	}

}
