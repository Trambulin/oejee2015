package hu.oe.pancakestore.jmsclient.simulator;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.jmsclient.PancakeProducer;
import hu.oe.pancakestore.jmsclient.QueueMessageProducer;
import hu.oe.pancakestore.serviceclient.domain.OrderHeaderStub;

public class EndlessSimulator {

	private static final Logger LOGGER = Logger.getLogger(EndlessSimulator.class);

	private  QueueMessageProducer producer;

	public EndlessSimulator(QueueMessageProducer producer) throws NamingException, JMSException {
		this.producer = producer;
		this.producer.openSession();
	}

	public void process(int delay) throws JMSException {
		while (true) {
			final OrderHeaderStub message = this.producer.createMessage();
			if (this.producer.sendObjectMessage(message)) {
				LOGGER.info(message);
			}
			try {
				Thread.sleep(delay);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
