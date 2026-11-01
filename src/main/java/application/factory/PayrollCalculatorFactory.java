package application.factory;

import application.data.PayrollData;
import application.data.PayrollField;
import application.model.EmployeeType;
import domain.service.PayrollCalculator;

import java.util.List;

public interface PayrollCalculatorFactory {
    EmployeeType supportedType();
    List<PayrollField> requiredFields();
    PayrollCalculator create(PayrollData data);
}