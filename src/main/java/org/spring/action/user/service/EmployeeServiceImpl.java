package org.spring.action.user.service;

import java.util.List;

import org.spring.action.user.Employee;
import org.spring.action.user.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    public void deleteEmployeeBySsn(String ssn) {
        employeeRepository.deleteEmployeeBySsn(ssn);
    }

    public Employee findBySsn(String ssn) {
        return employeeRepository.findBySsn(ssn);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }
}
