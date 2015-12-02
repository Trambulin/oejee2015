package hu.tram.ejbservice.management;

import javax.ejb.EJB;

import org.apache.log4j.Logger;

import hu.tram.ejbservice.holder.RentStateHolder;

public class RentMonitor implements RentMonitorMBean {

	private static final Logger LOGGER = Logger.getLogger(RentMonitor.class);

	@EJB
	private RentStateHolder stateHolder;
	
	@Override
	public int getCurrentTimeSpan() {
		return this.stateHolder.getCurrentTimeSpan();
	}

	@Override
	public void setCurrentTimeSpan(int months) {
		LOGGER.info("Set current time span: " + months);
		this.stateHolder.setCurrentTimeSpan(months);
	}
	
	public void start() throws Exception {
		LOGGER.info("Start Rent MBean");
	}

	public void stop() throws Exception {
		LOGGER.info("Stop Rent MBean");
	}

}
