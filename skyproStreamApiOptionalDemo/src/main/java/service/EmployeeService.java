package pro.sky.skyproStreamApiOptionalDemo.service;

import pro.sky.skyproStreamApiOptionalDemo.employee.Employee;
import pro.sky.skyproStreamApiOptionalDemo.exception.EmployeeAlreadyAddedException;
import pro.sky.skyproStreamApiOptionalDemo.exception.EmployeeNotFoundException;
import pro.sky.skyproStreamApiOptionalDemo.exception.EmployeeStorageIsFullException;

import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName, String middleName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    Employee remove(String firstName, String lastName, String middleName)
            throws EmployeeNotFoundException;

    Employee find(String firstName, String lastName, String middleName)
            throws EmployeeNotFoundException;

    List<Employee> getAll();
}