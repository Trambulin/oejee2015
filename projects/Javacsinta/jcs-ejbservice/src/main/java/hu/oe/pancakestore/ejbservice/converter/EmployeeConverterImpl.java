package hu.oe.pancakestore.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.oe.pancakestore.serviceclient.domain.EmployeeStub;

import hu.oe.pancakestore.persistence.entity.Employee;


@Stateless

public class EmployeeConverterImpl implements EmployeeConverter {

@EJB
private AddressConverter addressconverter;
	
	@Override
	public EmployeeStub to(Employee employee) {
		
		return new EmployeeStub(this.addressconverter.to(employee.getAddress()),employee.getName(),employee.getPhone(),employee.getOther_details());
	}

	@Override
	public List<EmployeeStub> to(List<Employee> employees) {
		final List<EmployeeStub> result = new ArrayList<>();
		for (final Employee employee : employees) {
			result.add(this.to(employee));
		}
		return result;
	}

}
