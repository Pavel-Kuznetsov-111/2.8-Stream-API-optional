package pro.sky.skyproStreamApiOptionalDemo.conroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproStreamApiOptionalDemo.employee.Employee;
import pro.sky.skyproStreamApiOptionalDemo.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") Integer depId) {
        return departmentService.maxSalary(depId);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam("departmentId") Integer depId) {
        return departmentService.minSalary(depId);
    }

    @GetMapping("/all1")
    public List<Employee> printAllDepId(@RequestParam("departmentId") Integer depId) {
        return departmentService.printAllDepId(depId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmpByDep() {
        return departmentService.getEmpByDep();
    }

}