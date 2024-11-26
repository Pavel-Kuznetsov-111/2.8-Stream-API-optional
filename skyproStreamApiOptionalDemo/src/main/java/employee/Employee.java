package pro.sky.skyproStreamApiOptionalDemo.employee;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private double salary;
    private int departmentId;


    public String getFullName() {
        return firstName + " " + lastName + " " + middleName;
    }
}