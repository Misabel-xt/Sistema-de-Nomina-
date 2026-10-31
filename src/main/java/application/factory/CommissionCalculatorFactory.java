package application.factory;

import application.data.FieldKind;
import application.data.PayrollData;
import application.data.PayrollField;
import application.model.EmployeeType;
import domain.service.CommissionPayrollCalculator;
import domain.service.PayrollCalculator;

import java.util.List;

public final class CommissionCalculatorFactory implements PayrollCalculatorFactory {

    private static final String BASE_SALARY = "baseSalary";
    private static final String SALES = "sales";
    private static final String COMMISSION_RATE = "commissionRate";

    @Override
    public EmployeeType supportedType() {
        return EmployeeType.COMMISSION;
    }

    @Override
    public List<PayrollField> requiredFields() {
        return List.of(
                new PayrollField(BASE_SALARY, "Salario base", FieldKind.NUMBER),
                new PayrollField(SALES, "Ventas del mes", FieldKind.NUMBER),
                new PayrollField(COMMISSION_RATE, "Porcentaje de comisión (ej. 5)", FieldKind.NUMBER));
    }

    @Override
    public PayrollCalculator create(PayrollData data) {
        return new CommissionPayrollCalculator(
                data.money(BASE_SALARY),
                data.sales(SALES),
                data.percentage(COMMISSION_RATE));
    }
}