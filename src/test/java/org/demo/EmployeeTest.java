package org.demo;

import java.math.BigDecimal;
import java.util.List;

import org.config.BaseTest;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.spring.action.user.Employee;
import org.spring.action.user.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeTest extends BaseTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void insert() {
        Employee employee1 = new Employee();
        employee1.setName("Han Yenn");
        employee1.setJoiningDate(new LocalDate(2010, 10, 10));
        employee1.setSalary(new BigDecimal(10000));
        employee1.setSsn("ssn00000001");

        /*
         * Create Employee2
         */
        Employee employee2 = new Employee();
        employee2.setName("Dan Thomas");
        employee2.setJoiningDate(new LocalDate(2012, 11, 11));
        employee2.setSalary(new BigDecimal(20000));
        employee2.setSsn("ssn00000002");

        /*
         * Persist both Employees
         */
        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);

        /*
         * Get all employees list from database
         */
        List<Employee> employees = employeeService.findAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        /*
         * delete an employee
         */
        employeeService.deleteEmployeeBySsn("ssn00000002");

        /*
         * update an employee
         */

        Employee employee = employeeService.findBySsn("ssn00000001");
        employee.setSalary(new BigDecimal(50000));
        employeeService.updateEmployee(employee);

        /*
         * Get all employees list from database
         */
        List<Employee> employeeList = employeeService.findAllEmployees();
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

    }
}
