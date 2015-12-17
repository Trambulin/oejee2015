package hu.oe.pancakestore.jmsclient;

import java.util.Random;

import javax.naming.NamingException;

import hu.oe.pancakestore.jmsclient.generator.PancakeMessageGenerator;
import hu.oe.pancakestore.serviceclient.domain.OrderHeaderStub;

public class PancakeProducer extends QueueMessageProducer {

	private final PancakeMessageGenerator messageGenerator;

	public PancakeProducer(String providerUrl, String userName, String password, String destination, Random random) throws NamingException {
		super(providerUrl, userName, password, destination);
		this.messageGenerator = new PancakeMessageGenerator(random);
	}

	@Override
	public OrderHeaderStub createMessage() {
		return this.messageGenerator.generate();
	}

}
