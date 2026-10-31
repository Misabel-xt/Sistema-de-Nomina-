package application.usecase;

import application.data.PayrollData;
import application.factory.PayrollCalculatorRegistry;
import application.model.EmployeeRecord;
import application.repository.EmployeeRepository;
import domain.exceptions.EmployeeNotFoundException;
import domain.model.Employee;
import domain.service.PayrollCalculator;
import domain.vo.Payroll;

import java.util.Objects;
import java.util.UUID;

public final class GeneratePayrollUseCase {

    private final EmployeeRepository repository;
    private final PayrollCalculatorRegistry registry;

    public GeneratePayrollUseCase(EmployeeRepository repository, PayrollCalculatorRegistry registry) {
        this.repository = Objects.requireNonNull(repository, "El repositorio no puede ser nulo.");
        this.registry = Objects.requireNonNull(registry, "El registro no puede ser nulo.");
    }

    public Payroll execute(UUID employeeId, PayrollData data) {
        EmployeeRecord record = repository.findById(employeeId)
                .orElseThrow(() -> EmployeeNotFoundException.withId(employeeId));

        PayrollCalculator calculator = registry.forType(record.type()).create(data);

        return new Employee(record.id(), record.name(), calculator).generatePayroll();
    }
}