package hu.tram.jmsclient;

public class Application {

	private static final String PROVIDER_URL = "remote://localhost:4447";
	private static final String USERNAME = "jmstestuser";
	private static final String PASSWORD = "User#70365";
	private static final String DESTINATION_LOTTERY = "jms/queue/rentqueue";

	public static void main(final String[] args) {
		sendSingleMessage();
	}

	public static void sendSingleMessage() {
		String msg="1;1;2015.05.05;2016.05.05";
		try {
			new QueueMessageProducer(Application.PROVIDER_URL, Application.USERNAME, Application.PASSWORD, Application.DESTINATION_LOTTERY)
					.standaloneSendMessage(msg);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
