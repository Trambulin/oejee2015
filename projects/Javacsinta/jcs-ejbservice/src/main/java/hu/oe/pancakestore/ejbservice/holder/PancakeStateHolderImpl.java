package hu.oe.pancakestore.ejbservice.holder;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Lock;
import javax.ejb.LockType;

import org.apache.log4j.Logger;

@Singleton(mappedName = "ejb/pancakestoreState")
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class PancakeStateHolderImpl implements PancakeStateHolder {

	
	private static final Logger LOGGER = Logger.getLogger(PancakeStateHolderImpl.class);
	
	private int reduction;
	
	@PostConstruct
	public void initialize() {
		LOGGER.info("PancakeStateHolder is initialized.");
		this.reduction=0;
	}
	
	@Override
	@Lock(LockType.READ)
	public int getCurrentReduction() {
		return this.reduction;
	}

	@Override
	@Lock(LockType.WRITE)
	public void setCurrentReduction(int reduction) {
		LOGGER.info("Change reduction rate: " + reduction);
		this.reduction=reduction;

	}

}
