package hu.tram.ejbservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hu.tram.ejbservice.converter.RentConverter;
import hu.tram.ejbservice.domain.RentDetailStub;
import hu.tram.ejbservice.exception.FacadeException;
import hu.tram.persistence.entity.Customer;
import hu.tram.persistence.exception.PersistenceServiceException;
import hu.tram.persistence.service.CarService;
import hu.tram.persistence.service.CustomerService;
import hu.tram.persistence.service.RentService;
import hu.tram.persistence.result.RentDetailResult;
import hu.tram.persistence.entity.trunk.Brand;

public class RentFacadeImplTest {
	private static final String CUSTOMER_LOGIN_NAME = "Zoleee";
	private static final Long CUSTOMER_ID = 1L;

	@InjectMocks
	private RentFacadeImpl facade;

	@Mock
	private CustomerService customerService;

	@Mock
	private CarService carService;

	@Mock
	private RentService rentService;

	@Mock
	private RentConverter rentConverter;
	
	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createListOfRentDetailsFromCustomerLoginName() throws FacadeException, PersistenceServiceException {
		Customer customer = Mockito.mock(Customer.class);
		Mockito.when(this.customerService.readLogin(CUSTOMER_LOGIN_NAME)).thenReturn(customer);
		Mockito.when(customer.getId()).thenReturn(CUSTOMER_ID);
		List<RentDetailResult> results = new ArrayList<>();
		//results.add(new RentDetailResult(Brand.AUDI, new Date(), 0));
		results.add(new RentDetailResult(Brand.BMW, new Date(), 0));
		Mockito.when(this.rentService.read(CUSTOMER_ID)).thenReturn(results);
		List<RentDetailStub> stubs = new ArrayList<>();
		//RentDetailStub audiStub = Mockito.mock(RentDetailStub.class);
		//stubs.add(audiStub);
		int yearBMW = 2013;
		double averagePriceBMW = 399999;
		stubs.add(new RentDetailStub(Brand.BMW.toString(), yearBMW, averagePriceBMW));
		Mockito.when(this.rentConverter.to(results)).thenReturn(stubs);
		
		List<RentDetailStub> rentDetailStubs = this.facade.getRentDetails(CUSTOMER_LOGIN_NAME);

		Mockito.verify(this.rentService).read(CUSTOMER_ID);	//its only for method call test, in this case its unnecessary

		Assert.assertEquals(rentDetailStubs.size(), stubs.size());
		//Assert.assertEquals(rentDetailStubs.get(0), audiStub);
		Assert.assertEquals(rentDetailStubs.get(0).getBrand(), Brand.BMW.toString());
		Assert.assertEquals(rentDetailStubs.get(0).getYear(), yearBMW);
		Assert.assertEquals(rentDetailStubs.get(0).getAveragePrice(), averagePriceBMW);
	}
}
