package pro.sky.skyproStreamApiOptionalDemo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.skyproStreamApiOptionalDemo.employee.Employee;
import pro.sky.skyproStreamApiOptionalDemo.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class DepartmentServiceImpl implements DepartmentService {


    private final EmployeeService employeeService;

    public DepartmentServiceImpl(@Qualifier("employeeServiceImpl") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee maxSalary(Integer depId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == depId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("This employee has not been found"));
    }

    @Override
    public Employee minSalary(Integer depId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == depId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("This employee has not been found"));
    }

    @Override
    public List<Employee> printAllDepId(Integer depId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == depId)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getEmpByDep() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}