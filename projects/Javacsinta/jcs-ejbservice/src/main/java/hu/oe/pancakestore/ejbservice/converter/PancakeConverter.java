package hu.oe.pancakestore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.serviceclient.domain.PancakeStub;
import hu.oe.pancakestore.persistence.entity.Pancake;

@Local
public interface PancakeConverter {
	
	PancakeStub to (Pancake pancake);
	List<PancakeStub> to (List<Pancake> pancakes);

}
