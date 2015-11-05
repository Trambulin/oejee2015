package hu.qwaevisz.bookstore.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.bookstore.persistence.entity.Employee;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;

@Local
public interface EmployeeService {
	Employee read(Long id) throws PersistenceServiceException;

	Employee read(String name) throws PersistenceServiceException;

	List<Employee> readAll() throws PersistenceServiceException;
}
