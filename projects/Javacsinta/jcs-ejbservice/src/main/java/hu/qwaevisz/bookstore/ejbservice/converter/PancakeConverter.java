package hu.qwaevisz.bookstore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.ejbservice.domain.PancakeStub;
import hu.qwaevisz.bookstore.persistence.entity.Pancake;

@Local
public interface PancakeConverter {
	
	PancakeStub to (Pancake pancake);
	List<PancakeStub> to (List<Pancake> pancakes);

}
