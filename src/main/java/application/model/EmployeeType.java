package application.model;

public enum EmployeeType {
    SALARIED("Asalariado"),
    HOURLY("Por horas"),
    COMMISSION("Por comisión"),
    TEMPORARY("Temporal");

    private final String label;

    EmployeeType(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
