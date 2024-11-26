package pro.sky.skyproStreamApiOptionalDemo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.skyproStreamApiOptionalDemo.employee.Employee;
import pro.sky.skyproStreamApiOptionalDemo.exception.EmployeeNotFoundException;

import java.util.List;
import java.util.Map;

public interface DepartmentService {


    Employee maxSalary(Integer depId) throws EmployeeNotFoundException;

    Employee minSalary(Integer depId) throws EmployeeNotFoundException;

    List<Employee> printAllDepId(Integer depId);

    Map<Integer, List<Employee>> getEmpByDep();

}