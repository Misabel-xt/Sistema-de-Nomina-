package application.exception;

import domain.exceptions.DomainException;
import java.util.UUID;

public class EmployeeNotFoundException extends DomainException {

    private EmployeeNotFoundException(String message) {
        super(message);
    }

    public static EmployeeNotFoundException withId(UUID id) {
        return new EmployeeNotFoundException("No existe un empleado con el id: " + id);
    }
}
