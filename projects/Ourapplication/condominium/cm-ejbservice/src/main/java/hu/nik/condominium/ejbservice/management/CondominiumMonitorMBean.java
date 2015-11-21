package hu.nik.condominium.ejbservice.management;

public interface CondominiumMonitorMBean {

	String getPuller();

	void setPuller(String name);

	Integer getPrizePool();

	void setPrizePool(Integer value);

	int getDistribution(int hit);

	int[] getDistributions();

	void setDistribution(int hit, int value);

}
