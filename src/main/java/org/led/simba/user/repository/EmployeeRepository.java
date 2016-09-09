package org.led.simba.user.repository;

import java.util.List;

import org.led.simba.user.Employee;

public interface EmployeeRepository {

    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployeeBySsn(String ssn);

    Employee findBySsn(String ssn);

    void updateEmployee(Employee employee);
}
