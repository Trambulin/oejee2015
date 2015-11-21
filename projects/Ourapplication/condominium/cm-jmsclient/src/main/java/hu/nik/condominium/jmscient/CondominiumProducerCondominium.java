package hu.nik.condominium.jmscient;

import hu.nik.condominium.jmscient.generator.CondominiumMessageGenerator;

import javax.naming.NamingException;
import java.util.Random;

public class CondominiumProducerCondominium extends QueueMessageProducer {

	private final CondominiumMessageGenerator messageGenerator;

	public CondominiumProducerCondominium(String providerUrl, String userName, String password, String destination, Random random) throws NamingException {
		super(providerUrl, userName, password, destination);
		this.messageGenerator = new CondominiumMessageGenerator(random);
	}

	@Override
	public String createMessage() {
		return this.messageGenerator.generate();
	}

}
