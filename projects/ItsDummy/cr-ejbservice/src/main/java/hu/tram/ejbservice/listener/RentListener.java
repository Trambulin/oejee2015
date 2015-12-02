package hu.tram.ejbservice.listener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import hu.tram.ejbservice.exception.FacadeException;
import hu.tram.ejbservice.facade.RentFacade;
import hu.tram.ejbservice.holder.RentStateHolder;

@MessageDriven(name = "RentListener", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "rentqueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class RentListener implements MessageListener {

	private static final Logger LOGGER = Logger.getLogger(RentListener.class);
	
	@EJB
	private RentFacade facade;
	
	@EJB
	private RentStateHolder stateHolder;

	@PostConstruct
	public void initialize() {
		LOGGER.info("Rent Listener created...");
	}
	
	@Override
	public void onMessage(Message message) {
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
				content = content.replace("[", "");
				content = content.replace("]", "");
				final String[] contentsStr = content.split(";");
				Long carId=Long.parseLong(contentsStr[0],10);
				String customerLogin=contentsStr[1];
				DateFormat format=new SimpleDateFormat("yyyy.MM.dd");
				Date rentDate = format.parse(contentsStr[2]);
				Calendar cal=Calendar.getInstance();
				cal.setTime(rentDate);
				cal.add(Calendar.MONTH, stateHolder.getCurrentTimeSpan());
				this.facade.addRent(carId, customerLogin, rentDate, cal.getTime());
			} else {
				LOGGER.error("Received message is not a TextMessage (" + message + ")");
			}
		} catch (final JMSException | FacadeException | NumberFormatException | ParseException e) {
			LOGGER.error(e, e);
		}
	}

}
