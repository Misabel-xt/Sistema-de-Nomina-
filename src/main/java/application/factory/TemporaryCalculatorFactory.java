package application.factory;

import application.data.FieldKind;
import application.data.PayrollData;
import application.data.PayrollField;
import application.model.EmployeeType;
import domain.service.PayrollCalculator;
import domain.service.TemporaryPayrollCalculator;

import java.util.List;

public final class TemporaryCalculatorFactory implements PayrollCalculatorFactory {

    private static final String MONTHLY_SALARY = "monthlySalary";

    @Override
    public EmployeeType supportedType() {
        return EmployeeType.TEMPORARY;
    }

    @Override
    public List<PayrollField> requiredFields() {
        return List.of(new PayrollField(MONTHLY_SALARY, "Salario mensual", FieldKind.NUMBER));
    }

    @Override
    public PayrollCalculator create(PayrollData data) {
        return new TemporaryPayrollCalculator(data.money(MONTHLY_SALARY));
    }
}