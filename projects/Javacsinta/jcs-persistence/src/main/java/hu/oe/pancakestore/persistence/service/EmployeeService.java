package hu.oe.pancakestore.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.oe.pancakestore.persistence.entity.Employee;
import hu.oe.pancakestore.persistence.exception.PersistenceServiceException;

@Local
public interface EmployeeService {
	Employee read(Long id) throws PersistenceServiceException;

	Employee read(String name) throws PersistenceServiceException;

	Employee readbyPhone(String phone) throws PersistenceServiceException;
	
	List<Employee> readAll() throws PersistenceServiceException;
}
