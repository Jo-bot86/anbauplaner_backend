package de.nadu_ocholt.anbauplaner.domain.plant.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Period;

@Converter(autoApply = true)
public class PeriodToLongConverter implements AttributeConverter<Period, Long> {
    @Override
    public Long convertToDatabaseColumn(Period period) {
        return period == null ? null : period.getDays() + period.getMonths() * 30L + period.getYears() * 365L;
        // alternativ nur period.getDays(), wenn du Monate/Jahre nicht berücksichtigen willst
    }

    @Override
    public Period convertToEntityAttribute(Long days) {
        return days == null ? null : Period.ofDays(days.intValue());
        // oder: konvertiere in Jahre/Monate/Tage, wenn du komplexer willst
    }
}
