package hu.nik.condominium.ejbservice.listener;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "CondominiumListener", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "condominiumqueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class LotteryListener implements MessageListener {

	private static final Logger LOGGER = Logger.getLogger(LotteryListener.class);

/*	@EJB
	private LotteryFacade facade;*/

	@PostConstruct
	public void initialize() {
		LOGGER.info("Lottery Listener created...");
	}

	@Override
	public void onMessage(final Message message) {
		LOGGER.info("*******CALLED******");
/*		try {
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
				final String[] numbersStr = content.split(",");
				final int[] numbers = new int[numbersStr.length];
				int i = 0;
				for (final String numberStr : numbersStr) {
					numbers[i++] = Integer.valueOf(numberStr.trim());
				}
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Parsed content: " + Arrays.toString(numbers));
				}
				this.facade.createNewEvent(numbers);
			} else {
				LOGGER.error("Received message is not a TextMessage (" + message + ")");
			}
		} catch (final JMSException | AdaptorException | NumberFormatException e) {
			LOGGER.error(e, e);
		}*/
	}

}
