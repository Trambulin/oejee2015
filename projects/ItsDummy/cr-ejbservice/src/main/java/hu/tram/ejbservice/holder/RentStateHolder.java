package hu.tram.ejbservice.holder;

import javax.ejb.Local;

@Local
public interface RentStateHolder {

	int getCurrentTimeSpan();

	void setCurrentTimeSpan(int months);
}
