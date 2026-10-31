package application.model;

import java.util.UUID;

public record EmployeeRecord(UUID id, String name, EmployeeType type) {}