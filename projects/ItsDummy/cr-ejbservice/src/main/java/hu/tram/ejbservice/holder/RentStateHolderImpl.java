package hu.tram.ejbservice.holder;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import org.apache.log4j.Logger;

@Singleton(mappedName = "ejb/rentState")
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class RentStateHolderImpl implements RentStateHolder {

	private static final Logger LOGGER = Logger.getLogger(RentStateHolderImpl.class);

	private int timeSpan;

	@PostConstruct
	public void initialize() {
		LOGGER.info("RentStateHolder is initialized.");
		this.timeSpan = 12;
	}
	
	@Override
	@Lock(LockType.READ)
	public int getCurrentTimeSpan() {
		return this.timeSpan;
	}

	@Override
	@Lock(LockType.WRITE)
	public void setCurrentTimeSpan(int months) {
		LOGGER.info("Change timeSpan: " + months);
		this.timeSpan=months;
	}

}
