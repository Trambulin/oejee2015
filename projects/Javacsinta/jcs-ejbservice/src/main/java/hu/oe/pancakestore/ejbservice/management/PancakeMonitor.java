package hu.oe.pancakestore.ejbservice.management;

import javax.ejb.EJB;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.ejbservice.holder.PancakeStateHolder;


public class PancakeMonitor implements PancakeMonitorMBean {

	private static final Logger LOGGER = Logger.getLogger(PancakeMonitor.class);

	@EJB
	private PancakeStateHolder stateHolder;
	
	@Override
	public int getReductionRate() {
		
		return this.stateHolder.getCurrentReduction();
	}

	@Override
	public void setReductionRate(int value) {

		LOGGER.info("Set current reduction rate: " + value);
		this.stateHolder.setCurrentReduction(value);
		
	}

	public void start() throws Exception {
		LOGGER.info("Start Pancake MBean");
	}

	public void stop() throws Exception {
		LOGGER.info("Stop Pancake MBean");
	}

}
