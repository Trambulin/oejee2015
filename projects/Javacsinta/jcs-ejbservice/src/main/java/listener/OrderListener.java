package listener;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.ejbservice.facade.OrderHeaderFacade;
import hu.oe.pancakestore.serviceclient.domain.CustomerStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;



@MessageDriven(name = "OrderListener", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "pancakequeue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class OrderListener implements MessageListener {

	private static final Logger LOGGER = Logger.getLogger(OrderListener.class);

	@EJB
	private OrderHeaderFacade facade;

	@PostConstruct
	public void initialize() {
		LOGGER.info("Lottery Listener created...");
	}

	@Override
	public void onMessage(final Message message) {
		try {
			if (LOGGER.isDebugEnabled()) {
				final Queue destination = (Queue) message.getJMSDestination();
				final String queueName = destination.getQueueName();
				LOGGER.debug("New JMS message arrived into " + queueName + " queue (correlation id: " + message.getJMSCorrelationID() + ")");
			}

			if (message instanceof ObjectMessage) {
				final ObjectMessage objectMessage = (ObjectMessage) message;
				Object content = objectMessage.getObject();
				CustomerStub customer= (CustomerStub)content;
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Received message: " + customer);
				}
//				content = content.replace("[", "");
//				content = content.replace("]", "");
//				final String[] numbersStr = content.split(",");
//				final int[] numbers = new int[numbersStr.length];
//				int i = 0;
//				for (final String numberStr : numbersStr) {
//					numbers[i++] = Integer.valueOf(numberStr.trim());
//				}
//				if (LOGGER.isDebugEnabled()) {
//					LOGGER.debug("Parsed content: " + Arrays.toString(numbers));
//				}
				//this.facade.createNewEvent(numbers);
			} else {
				LOGGER.error("Received message is not a TextMessage (" + message + ")");
			}
		} catch (final JMSException | /*FacadeException |*/ NumberFormatException e) {
			LOGGER.error(e, e);
		}
	}

}
