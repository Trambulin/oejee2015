package hu.qwaevisz.bookstore.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.ejbservice.domain.EmployeeStub;
import hu.qwaevisz.bookstore.persistence.entity.Employee;




@Local
public interface EmployeeConverter {

	EmployeeStub to(Employee employee);

	List<EmployeeStub> to(List<Employee> employees);

}
