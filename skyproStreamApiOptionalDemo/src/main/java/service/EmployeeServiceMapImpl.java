package pro.sky.skyproStreamApiOptionalDemo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pro.sky.skyproStreamApiOptionalDemo.employee.Employee;
import pro.sky.skyproStreamApiOptionalDemo.exception.EmployeeAlreadyAddedException;
import pro.sky.skyproStreamApiOptionalDemo.exception.EmployeeNotFoundException;
import pro.sky.skyproStreamApiOptionalDemo.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class EmployeeServiceMapImpl implements EmployeeService {

    private final int MAP_SIZE = 10;

    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "Ivan Ivanov Ivanovich", new Employee("Ivan", "Ivanov", "Ivanovich"),
            "Petr Petrov Petrovich", new Employee("Petr", "Petrov", "Petrovich"),
            "Harry Potter Maratovich", new Employee("Harry", "Potter", "Maratovich"),
            "Olga Simonova Petrovna", new Employee("Olga", "Simonova", "Petrovna"),
            "Anastasia Zvyagina Viktorovich", new Employee("Anastasia", "Zvyagina", "Viktorovich")
    ));


    @Override
    public Employee add(String firstName, String lastName, String middleName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {

        Employee employee = new Employee(firstName, lastName, middleName);

        if (employees.size() >= MAP_SIZE) {
            throw new EmployeeStorageIsFullException("The list size is exceeded!!!");
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Such an employee already exists!!!");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, String middleName)
            throws EmployeeNotFoundException {

        Employee employee = new Employee(firstName, lastName, middleName);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("This employee has not been found");
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, String middleName)
            throws EmployeeNotFoundException {

        Employee employee = new Employee(firstName, lastName, middleName);

        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException("This employee has not been found");
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
}