package pro.sky.skyproStreamApiOptionalDemo.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}