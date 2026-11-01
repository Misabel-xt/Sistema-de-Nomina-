package application.model;

import application.model.EmployeeRecord;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository {
    Optional<EmployeeRecord> findById(UUID id);
    List<EmployeeRecord> findAll();
}