package hu.nik.condominium.ejbservice.holder;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.*;

@Singleton(mappedName = "ejb/condominiumState")
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class CondominiumStateHolderImpl implements CondominiumStateHolder {

	private static final Logger LOGGER = Logger.getLogger(CondominiumStateHolderImpl.class);

	private boolean enabled;

	@PostConstruct
	public void initialize() {
		LOGGER.info("CondominiumStateHolder is initialized.");
		this.enabled=true;
	}

	@Override
	@Lock(LockType.READ)
	public boolean getEnabled() {
		return this.enabled;
	}

	@Override
	@Lock(LockType.WRITE)
	public void setEnabled(boolean enabled) {
			this.enabled=enabled;
	}

}
