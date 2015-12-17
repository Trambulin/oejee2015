package hu.oe.pancakestore.jmsclient.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import hu.oe.pancakestore.client.CustomerClient;
import hu.oe.pancakestore.client.EmployeeClient;
import hu.oe.pancakestore.client.PancakeClient;
import hu.oe.pancakestore.serviceclient.domain.AddressStub;
import hu.oe.pancakestore.serviceclient.domain.CustomerStub;
import hu.oe.pancakestore.serviceclient.domain.DeliveryStatusStub;
import hu.oe.pancakestore.serviceclient.domain.EmployeeStub;
import hu.oe.pancakestore.serviceclient.domain.OrderHeaderStub;
import hu.oe.pancakestore.serviceclient.domain.OrderItemStub;
import hu.oe.pancakestore.serviceclient.domain.PancakeStub;
import hu.oe.pancakestore.serviceclient.domain.PaymentMethodStub;

public class PancakeMessageGenerator {

	private static final int NUMBER_OF_MAX_ITEMS = 2;
	private static final int MAXIMUM_VALUE = 90;

	private final Random random;

	public PancakeMessageGenerator(Random random) {
		this.random = random;
	}

	public OrderHeaderStub generate() {

		OrderHeaderStub orderHeaderStub= new OrderHeaderStub(new CustomerStub(new AddressStub(1037,"KUNIGUNDA UTJA 35.","2B"),"KOVACS JANOS","0630-5650257","kovacs.janos@gmail.com",""),new EmployeeStub(new AddressStub(1117,"IRINYI JOZSEF UTCA 42.","808"),"NAGY JOZSEF","0670-43-53-187",""),DeliveryStatusStub.InProgress,2000.0F,new Date(),PaymentMethodStub.CARD);
		orderHeaderStub.addorderItems(new OrderItemStub(new PancakeStub("CSOKIS PALACSINTA",1000,""),2,2000.0F));
		
		CustomerClient customerClient= new CustomerClient();
		List<CustomerStub> customers= customerClient.invoke();
		
		PancakeClient pancakeClient= new PancakeClient();
		List<PancakeStub> pancakes= pancakeClient.invoke();
		
		EmployeeClient employeeClient= new EmployeeClient();
		List<EmployeeStub> employees= employeeClient.invoke();
		
		int rndcustomer=this.random.nextInt(customers.size());
		int rndemployee=this.random.nextInt(employees.size());
		
		orderHeaderStub=new OrderHeaderStub(customers.get(rndcustomer),employees.get(rndemployee),DeliveryStatusStub.InProgress,1000.0F,new Date(),PaymentMethodStub.CARD);
		
		List<Integer> listOfAlreadyChosenPancakes=new ArrayList<Integer>();
		
		int rndnumberofOrders=this.random.nextInt(NUMBER_OF_MAX_ITEMS)+1;
		for (int i = 0; i < rndnumberofOrders; i++) {
			
			int rndpancake=this.random.nextInt(pancakes.size());
			listOfAlreadyChosenPancakes.add(rndpancake);
			do {
				rndpancake = this.random.nextInt(pancakes.size());
			} while (listOfAlreadyChosenPancakes.contains(rndpancake));
			orderHeaderStub.addorderItems(new OrderItemStub(pancakes.get(rndpancake),1,(float) pancakes.get(rndpancake).getPrice()));
			
		}
		
		return orderHeaderStub;
	}

}
