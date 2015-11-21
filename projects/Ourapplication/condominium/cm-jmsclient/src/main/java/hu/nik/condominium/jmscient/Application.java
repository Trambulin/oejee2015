package hu.nik.condominium.jmscient;

import hu.nik.condominium.jmscient.simulator.EndlessSimulator;

import java.util.Random;

public class Application {

	private static final String PROVIDER_URL = "remote://localhost:4447";
	private static final String USERNAME = "jmstestuser";
	private static final String PASSWORD = "TestUser#666999";
	private static final String DESTINATION_LOTTERY = "jms/queue/condominiumqueue";

	public static void main(final String[] args) {
		 sendSingleMessage();
		//startSimulation(new Random(), 4000);
	}

	public static void sendSingleMessage() {
		try {
			new QueueMessageProducer(
					Application.PROVIDER_URL,
					Application.USERNAME,
					Application.PASSWORD,
					Application.DESTINATION_LOTTERY)
					.standaloneSendMessage("1, 2, 3, 4, 5");
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void startSimulation(final Random random, final int delay) {
		try {
			final CondominiumProducerCondominium producer = new CondominiumProducerCondominium(
					Application.PROVIDER_URL,
					Application.USERNAME,
					Application.PASSWORD,
					Application.DESTINATION_LOTTERY,
					random);
			final EndlessSimulator simulator = new EndlessSimulator(producer);
			simulator.process(delay);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
