package pro.sky.skyproStreamApiOptionalDemo.conroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproStreamApiOptionalDemo.employee.Employee;
import pro.sky.skyproStreamApiOptionalDemo.service.EmployeeService;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("middleName") String middleName) {
        return employeeService.add(firstName, lastName, middleName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("middleName") String middleName) {
        return employeeService.remove(firstName, lastName, middleName);
    }


    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("middleName") String middleName) {
        return employeeService.find(firstName, lastName, middleName);
    }

    @GetMapping(path = "/allEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }
}