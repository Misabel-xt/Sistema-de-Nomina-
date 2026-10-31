package application.exception;

import domain.exceptions.DomainException;

public class InvalidPayrollDataException extends DomainException {

    private InvalidPayrollDataException(String message) {
        super(message);
    }

    public static InvalidPayrollDataException missing(String field) {
        return new InvalidPayrollDataException("El dato '" + field + "' es obligatorio.");
    }

    public static InvalidPayrollDataException notANumber(String field) {
        return new InvalidPayrollDataException("El dato '" + field + "' debe ser un valor numérico.");
    }
}