package hu.oe.pancakestore.jmsclient;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import hu.oe.pancakestore.serviceclient.domain.AddressStub;
import hu.oe.pancakestore.serviceclient.domain.CustomerStub;

public class SimpleClient {

	public static void main(String[] args) throws NamingException, JMSException {
		final Properties environment = new Properties();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		environment.put(Context.PROVIDER_URL, "remote://localhost:4447");
		environment.put(Context.SECURITY_PRINCIPAL, "jmstestuser");
		environment.put(Context.SECURITY_CREDENTIALS, "User#70365");
		Context context = new InitialContext(environment);

		final ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
		final Destination destination = (Destination) context.lookup("jms/queue/pancakequeue");

		Connection connection = connectionFactory.createConnection("jmstestuser", "User#70365");
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		final MessageProducer producer = session.createProducer(destination);
		connection.start();

		final ObjectMessage objectMessage=session.createObjectMessage(new CustomerStub(new AddressStub(1111,"Utca","Házszám"),"Bunyós Pityú","0672 23 23 233","pityu.bunyos@gmail.com","Agresszív vásárló"));
		
		producer.send(objectMessage);
		
		
		connection.close();
	}

}
