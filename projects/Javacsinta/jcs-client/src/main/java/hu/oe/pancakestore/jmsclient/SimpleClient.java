package hu.oe.pancakestore.jmsclient;

import java.util.Date;
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
import hu.oe.pancakestore.serviceclient.domain.DeliveryStatusStub;
import hu.oe.pancakestore.serviceclient.domain.EmployeeStub;
import hu.oe.pancakestore.serviceclient.domain.OrderHeaderStub;
import hu.oe.pancakestore.serviceclient.domain.PancakeStub;
import hu.oe.pancakestore.serviceclient.domain.PaymentMethodStub;
import hu.oe.pancakestore.serviceclient.domain.OrderItemStub;

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

		OrderHeaderStub orderHeaderStub= new OrderHeaderStub(new CustomerStub(new AddressStub(1037,"KUNIGUNDA UTJA 35.","2B"),"KOVACS JANOS","0630-5650257","kovacs.janos@gmail.com",""),new EmployeeStub(new AddressStub(1117,"IRINYI JOZSEF UTCA 42.","808"),"NAGY JOZSEF","0670-43-53-187",""),DeliveryStatusStub.InProgress,2000.0F,new Date(),PaymentMethodStub.CARD);
		orderHeaderStub.addorderItems(new OrderItemStub(new PancakeStub("CSOKIS PALACSINTA",1000,""),2,2000.0F));
		final ObjectMessage objectMessage=session.createObjectMessage(orderHeaderStub);
		
		producer.send(objectMessage);
		
		
		connection.close();
	}

}
