package hu.oe.pancakestore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.serviceclient.domain.EmployeeStub;
import hu.oe.pancakestore.persistence.entity.Employee;




@Local
public interface EmployeeConverter {

	EmployeeStub to(Employee employee);

	List<EmployeeStub> to(List<Employee> employees);

}
