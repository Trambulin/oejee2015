package hu.oe.pancakestore.client;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.serviceclient.CustomerFacadeRemote;
import hu.oe.pancakestore.serviceclient.domain.CustomerStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;

public class CustomerClient {

	private static final String JBOSS_INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String JBOSS_PROVIDER_URL = "remote://localhost:4447";
	private static final String JBOSS_URL_PKG_PREFIXES = "org.jboss.ejb.client.naming";

	private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY = "jboss.naming.client.ejb.context";
	private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE = "true";

	private static final Logger LOGGER = Logger.getLogger(CustomerClient.class);

	public static void main(String[] args) throws Exception {
		System.out.println(new CustomerClient().invoke());
	}

	public List<CustomerStub> invoke() {
		List<CustomerStub> customers = null;
		try {
			final CustomerFacadeRemote facade = this.lookup();
			customers = facade.getCustomers();
			LOGGER.info(customers);
		} catch (final FacadeException e) {
			e.printStackTrace();
		} catch (final NamingException e) {
			e.printStackTrace();
		}
		return customers;
	}

	private CustomerFacadeRemote lookup() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, JBOSS_INITIAL_CONTEXT_FACTORY);
		jndiProperties.put(Context.PROVIDER_URL, JBOSS_PROVIDER_URL);
		jndiProperties.put(Context.URL_PKG_PREFIXES, JBOSS_URL_PKG_PREFIXES);
		jndiProperties.put(JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY, JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE);
		final Context context = new InitialContext(jndiProperties);
		return (CustomerFacadeRemote) context.lookup("Javacsinta-1.0/jcs-ejbservice/CustomerFacadeImpl!hu.oe.pancakestore.serviceclient.CustomerFacadeRemote");
	}

}