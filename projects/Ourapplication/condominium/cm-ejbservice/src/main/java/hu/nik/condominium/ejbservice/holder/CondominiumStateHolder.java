package hu.nik.condominium.ejbservice.holder;

import javax.ejb.Local;

@Local
public interface CondominiumStateHolder {

	boolean getEnabled();

	void setEnabled(boolean enabled);

}
