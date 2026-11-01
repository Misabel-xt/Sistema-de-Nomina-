package application.usecase;

import application.model.EmployeeRecord;
import application.repository.EmployeeRepository;

import java.util.List;
import java.util.Objects;

public final class ListEmployeesUseCase {

    private final EmployeeRepository repository;

    public ListEmployeesUseCase(EmployeeRepository repository) {
        this.repository = Objects.requireNonNull(repository, "El repositorio no puede ser nulo.");
    }

    public List<EmployeeRecord> execute() {
        return repository.findAll();
    }
}
