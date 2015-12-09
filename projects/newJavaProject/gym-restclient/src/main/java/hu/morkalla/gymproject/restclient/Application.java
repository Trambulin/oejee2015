package hu.morkalla.gymproject.restclient;

import hu.morkalla.gymproject.restclient.domain.TrainerStub;

public class Application {

	private static final String HOST = "localhost";
	private static final int PORT = 8081;

	public static void main(String[] args) {
		final GYMRestClient client = new GYMRestClient(HOST, PORT);
		final TrainerStub trainer = client.process("Kiss Imre");
		System.out.println(trainer);
	}

}