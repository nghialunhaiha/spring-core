package org.spring.action.user.repository;

import java.util.List;

import org.spring.action.user.Employee;


public interface EmployeeDao {

	void saveEmployee(Employee employee);
	
	List<org.spring.action.user.Employee> findAllEmployees();
	
	void deleteEmployeeBySsn(String ssn);
	
	Employee findBySsn(String ssn);
	
	void updateEmployee(Employee employee);
}
