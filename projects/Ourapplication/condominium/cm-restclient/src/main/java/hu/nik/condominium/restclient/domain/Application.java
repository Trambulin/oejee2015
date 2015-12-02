package hu.nik.condominium.restclient.domain;

import hu.nik.condominium.restclient.domain.domain.CondominiumCriteria;
import hu.nik.condominium.restclient.domain.domain.CondominiumStub;

/**
 * Created by Hidvégi Péter on 2015.11.29..
 */
public class Application {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        final CondominiumRestClient client = new CondominiumRestClient(HOST, PORT);
        final CondominiumStub condominium = client.process(new CondominiumCriteria("flat", 1, 4));
        System.out.println(condominium);
    }
}
