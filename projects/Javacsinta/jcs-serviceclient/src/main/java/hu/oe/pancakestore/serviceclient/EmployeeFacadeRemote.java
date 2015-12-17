package hu.oe.pancakestore.serviceclient;

import java.util.List;

import javax.ejb.Remote;

import hu.oe.pancakestore.serviceclient.domain.CustomerStub;
import hu.oe.pancakestore.serviceclient.domain.EmployeeStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;

@Remote
public interface EmployeeFacadeRemote {

	List<EmployeeStub> getEmployees () throws FacadeException;

}
