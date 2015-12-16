package hu.oe.pancakestore.ejbservice.holder;

import javax.ejb.Local;

@Local
public interface PancakeStateHolder {

	int getCurrentReduction();

	void setCurrentReduction(int reduction);
	
}
