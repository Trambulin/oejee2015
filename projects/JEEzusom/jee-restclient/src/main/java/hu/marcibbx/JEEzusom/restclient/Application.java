package hu.marcibbx.JEEzusom.restclient;

import hu.marcibbx.JEEzusom.restclient.domain.AccountStub;

public class Application {

	private static final String HOST = "localhost";
	private static final int PORT = 8080;

	public static void main(String[] args) {
		final JEEzusomRestClient client = new JEEzusomRestClient(HOST, PORT);
		final AccountStub account = client.process("marciemail@jeezusom.com");
		System.out.println("done");
	}

}
