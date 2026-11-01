package application.usecase;

import application.data.PayrollField;
import application.factory.PayrollCalculatorRegistry;
import application.model.EmployeeType;

import java.util.List;
import java.util.Objects;

public final class GetRequiredFieldsUseCase {

    private final PayrollCalculatorRegistry registry;

    public GetRequiredFieldsUseCase(PayrollCalculatorRegistry registry) {
        this.registry = Objects.requireNonNull(registry, "El registro no puede ser nulo.");
    }

    public List<PayrollField> execute(EmployeeType type) {
        return registry.forType(type).requiredFields();
    }
}