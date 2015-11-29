package hu.nik.condominium.restclient.domain;

import hu.nik.condominium.restclient.domain.domain.CondominiumCriteria;
import hu.nik.condominium.restclient.domain.domain.CondominiumStub;
import org.jboss.resteasy.client.ClientRequestFactory;
import org.jboss.resteasy.client.ClientResponse;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.logging.Logger;

/**
 * Created by Hidvégi Péter on 2015.11.29..
 */
public class CondominiumRestClient {

    private static final Logger LOGGER = Logger.getLogger(CondominiumRestClient.class.getSimpleName());

    private static final String SERVICE_CONTEXT_PATH = "/condominium/api";

    private final String host;
    private final int port;

    public CondominiumRestClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public CondominiumStub process(String condominiumLocation, CondominiumCriteria criteria) {
        final URI serviceUri = UriBuilder.fromUri(this.getServicePath()).build();
        final ClientRequestFactory crf = new ClientRequestFactory(serviceUri);

        final CondominiumRestService api = crf.createProxy(CondominiumRestService.class);
        final ClientResponse<CondominiumStub> response = api.getMarks(condominiumLocation, criteria);

        LOGGER.info("Response status: " + response.getStatus());
        final MultivaluedMap<String, Object> header = response.getMetadata();
        for (final String key : header.keySet()) {
            LOGGER.info("HEADER - key: " + key + ", value: " + header.get(key));
        }
        final CondominiumStub entity = response.getEntity();
        LOGGER.info("Response entity: " + entity);
        return entity;
    }

    private String getServicePath() {
        return "http://" + this.host + ":" + this.port + SERVICE_CONTEXT_PATH;
    }
}
