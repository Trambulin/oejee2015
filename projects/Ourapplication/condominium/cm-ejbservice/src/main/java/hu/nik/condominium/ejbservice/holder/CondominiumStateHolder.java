package hu.nik.condominium.ejbservice.holder;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CondominiumStateHolder {

	String getCurrentPuller();

	void setCurrentPuller(String name);

	Integer getCurrentPrizePool();

	void setCurrentPrizePool(int value);

	int getDistribution(int hit);

	List<Integer> getDistributions();

	void setDistribution(int hit, int value);

}
