package hu.tram.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import hu.tram.ejbserviceclient.CarFacadeRemote;
import hu.tram.ejbserviceclient.domain.CarStub;
import hu.tram.ejbserviceclient.exception.FacadeException;

public class CarClient {

	private static final String JBOSS_INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String JBOSS_PROVIDER_URL = "remote://localhost:4447";
	private static final String JBOSS_URL_PKG_PREFIXES = "org.jboss.ejb.client.naming";

	private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY = "jboss.naming.client.ejb.context";
	private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE = "true";

	private static final Logger LOGGER = Logger.getLogger(CarClient.class);

	public static void main(String[] args) throws Exception {
		System.out.println(new CarClient().invoke(0));
	}

	private CarStub invoke(int carId) {
		CarStub car = null;
		LOGGER.info("invoke method ran");
		try {
			final CarFacadeRemote facade = this.lookup();
			car = facade.getCarRemote(new Long(carId));
			LOGGER.info(car);
		} catch (final FacadeException e) {
			e.printStackTrace();
		} catch (final NamingException e) {
			e.printStackTrace();
		}
		return car;
	}

	private CarFacadeRemote lookup() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, JBOSS_INITIAL_CONTEXT_FACTORY);
		jndiProperties.put(Context.PROVIDER_URL, JBOSS_PROVIDER_URL);
		jndiProperties.put(Context.URL_PKG_PREFIXES, JBOSS_URL_PKG_PREFIXES);
		jndiProperties.put(JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY, JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE);
		final Context context = new InitialContext(jndiProperties);
		return (CarFacadeRemote) context.lookup("ItsDummy-1.0/cr-ejbservice/CarFacadeRemoteImpl!hu.tram.ejbserviceclient.CarFacadeRemote");
	}

}