package hu.nik.condominium.ejbservice.management;

import hu.nik.condominium.ejbservice.holder.CondominiumStateHolder;
import org.apache.log4j.Logger;

import javax.ejb.EJB;

public class CondominiumMonitor implements CondominiumMonitorMBean {

	private static final Logger LOGGER = Logger.getLogger(CondominiumMonitor.class);

	@EJB
	private CondominiumStateHolder stateHolder;

	@Override
	public void setEnabled(boolean enabled) {
		if(enabled)
			LOGGER.info("LISTENER ENABLED");
		else
			LOGGER.info("LISTENER DISABLED");

		this.stateHolder.setEnabled(enabled);
	}

	@Override
	public boolean getEnabled() {
		return this.stateHolder.getEnabled();
	}

	public void start() throws Exception {
		LOGGER.info("Start Condominium MBean");
	}

	public void stop() throws Exception {
		LOGGER.info("Stop Condominium MBean");
	}

}
