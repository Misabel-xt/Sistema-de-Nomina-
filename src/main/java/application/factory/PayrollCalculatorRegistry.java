package application.factory;

import application.model.EmployeeType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class PayrollCalculatorRegistry {

    private final Map<EmployeeType, PayrollCalculatorFactory> factories = new EnumMap<>(EmployeeType.class);

    public PayrollCalculatorRegistry(List<PayrollCalculatorFactory> availableFactories) {
        availableFactories.forEach(factory -> factories.put(factory.supportedType(), factory));
    }

    public PayrollCalculatorFactory forType(EmployeeType type) {
        PayrollCalculatorFactory factory = factories.get(type);
        if (factory == null) {
            throw new IllegalStateException("No hay estrategia de nómina registrada para: " + type.label());
        }
        return factory;
    }
}