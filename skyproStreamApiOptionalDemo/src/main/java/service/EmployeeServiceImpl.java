package pro.sky.skyproStreamApiOptionalDemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyproStreamApiOptionalDemo.employee.Employee;
import pro.sky.skyproStreamApiOptionalDemo.exception.EmployeeAlreadyAddedException;
import pro.sky.skyproStreamApiOptionalDemo.exception.EmployeeNotFoundException;
import pro.sky.skyproStreamApiOptionalDemo.exception.EmployeeStorageIsFullException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int LIST_SIZE = 10;

    private final List<Employee> employees = List.of(
            new Employee("Ivan", "Ivanov", "Ivanovich", 2000,1),
            new Employee("Petr", "Petrov", "Petrovich", 2500, 1),
            new Employee("Harry", "Potter", "Maratovich",3000,2),
            new Employee("Olga", "Simonova", "Petrovna",3000,2),
            new Employee("Anastasia", "Zvyagina", "Viktorovich",5000,3),
            new Employee("Karina","Smirnova","Pavlovna", 5500,3));


    @Override
    public Employee add(String firstName, String lastName, String middleName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName, middleName);
        if (employees.size() >= LIST_SIZE) {
            throw new EmployeeStorageIsFullException("The list size is exceeded!!!");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Such an employee already exists!!!");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, String middleName)
            throws EmployeeNotFoundException {

        Employee employee = new Employee(firstName, lastName, middleName);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("This employee has not been found");
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, String middleName)
            throws EmployeeNotFoundException {

        Employee employee = new Employee(firstName, lastName, middleName);

        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("This employee has not been found");
    }

    @Override
    public List<Employee> getAll() {
        return employees;

    }
}