package hu.oe.pancakestore.jmsclient;

import java.util.Random;

import hu.oe.pancakestore.jmsclient.simulator.EndlessSimulator;

public class Application {

	private static final String PROVIDER_URL = "remote://localhost:4447";
	private static final String USERNAME = "jmstestuser";
	private static final String PASSWORD = "User#70365";
	private static final String DESTINATION_LOTTERY = "jms/queue/pancakequeue";

	public static void main(final String[] args) {
		
		startSimulation(new Random(), 4000);
	}

	

	public static void startSimulation(final Random random, final int delay) {
		try {
			PancakeProducer producer = new PancakeProducer(Application.PROVIDER_URL, Application.USERNAME, Application.PASSWORD,
					Application.DESTINATION_LOTTERY, random);
			EndlessSimulator simulator = new EndlessSimulator(producer);
			simulator.process(delay);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}


	

}
