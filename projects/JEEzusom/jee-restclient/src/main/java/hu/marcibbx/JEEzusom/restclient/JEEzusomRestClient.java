package hu.marcibbx.JEEzusom.restclient;

import java.net.URI;
import java.util.logging.Logger;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.ClientRequestFactory;
import org.jboss.resteasy.client.ClientResponse;

import hu.marcibbx.JEEzusom.restclient.domain.AccountStub;

public class JEEzusomRestClient {

	private static final Logger LOGGER = Logger.getLogger(JEEzusomRestClient.class.getSimpleName());

	private static final String SERVICE_CONTEXT_PATH = "/JEEzusom/api";

	private final String host;
	private final int port;

	public JEEzusomRestClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public AccountStub process(String name) {
		final URI serviceUri = UriBuilder.fromUri(this.getServicePath()).build();
		final ClientRequestFactory crf = new ClientRequestFactory(serviceUri);

		final AccountRestService api = crf.createProxy(AccountRestService.class);
		final ClientResponse<AccountStub> response = api.getAccounts(name);

		LOGGER.info("Response status: " + response.getStatus());
		final MultivaluedMap<String, Object> header = response.getMetadata();
		for (final String key : header.keySet()) {
			LOGGER.info("HEADER - key: " + key + ", value: " + header.get(key));
		}
		final AccountStub entity = response.getEntity();
		LOGGER.info("Response entity: " + entity);
		return entity;
	}

	private String getServicePath() {
		return "http://" + this.host + ":" + this.port + SERVICE_CONTEXT_PATH;
	}

}
