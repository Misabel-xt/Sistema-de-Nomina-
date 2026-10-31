package application.data;

import application.exception.InvalidPayrollDataException;
import domain.vo.Money;
import domain.vo.Percentage;
import domain.vo.Sales;

import java.math.BigDecimal;
import java.util.Map;

public record PayrollData(Map<String, String> values) {

    public PayrollData {
        values = Map.copyOf(values);
    }

    public String text(String key) {
        String value = values.get(key);
        if (value == null || value.isBlank()) {
            throw InvalidPayrollDataException.missing(key);
        }
        return value.trim();
    }

    public int integer(String key) {
        try {
            return Integer.parseInt(text(key));
        } catch (NumberFormatException e) {
            throw InvalidPayrollDataException.notANumber(key);
        }
    }

    public short shortValue(String key) {
        try {
            return Short.parseShort(text(key));
        } catch (NumberFormatException e) {
            throw InvalidPayrollDataException.notANumber(key);
        }
    }

    public boolean yesNo(String key) {
        return text(key).equalsIgnoreCase("s");
    }

    public Money money(String key) {
        return new Money(decimal(key));
    }

    public Sales sales(String key) {
        return new Sales(decimal(key));
    }

    public Percentage percentage(String key) {
        return new Percentage(decimal(key));
    }

    private BigDecimal decimal(String key) {
        try {
            return new BigDecimal(text(key));
        } catch (NumberFormatException e) {
            throw InvalidPayrollDataException.notANumber(key);
        }
    }
}