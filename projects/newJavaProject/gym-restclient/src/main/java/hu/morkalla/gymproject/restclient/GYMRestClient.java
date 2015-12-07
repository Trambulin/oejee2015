package hu.morkalla.gymproject.restclient;

import java.net.URI;
import java.util.logging.Logger;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.ClientRequestFactory;
import org.jboss.resteasy.client.ClientResponse;

import hu.morkalla.gymproject.restclient.domain.TrainerStub;

public class GYMRestClient {

	private static final Logger LOGGER = Logger.getLogger(GYMRestClient.class.getSimpleName());
	private static final String SERVICE_CONTEXT_PATH = "/gym-webservices/api";

	private final String host;
	private final int port;

	public GYMRestClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public TrainerStub process(String trainerName) {
		final URI serviceUri = UriBuilder.fromUri(this.getServicePath()).build();
		final ClientRequestFactory crf = new ClientRequestFactory(serviceUri);

		final TrainerRestService api = crf.createProxy(TrainerRestService.class);
		final ClientResponse<TrainerStub> response = api.getTrainer(trainerName);

		LOGGER.info("Response status: " + response.getStatus());
		final MultivaluedMap<String, Object> header = response.getMetadata();
		for (final String key : header.keySet()) {
			LOGGER.info("HEADER - key: " + key + ", value: " + header.get(key));
		}
		final TrainerStub entity = response.getEntity();
		LOGGER.info("Response entity: " + entity);
		return entity;
	}

	private String getServicePath() {
		return "http://" + this.host + ":" + this.port + SERVICE_CONTEXT_PATH;
	}
}
