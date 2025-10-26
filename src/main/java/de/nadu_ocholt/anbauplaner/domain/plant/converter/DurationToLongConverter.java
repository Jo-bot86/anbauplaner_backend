package de.nadu_ocholt.anbauplaner.domain.plant.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Duration;

@Converter(autoApply = true)
public class DurationToLongConverter implements AttributeConverter<Duration, Long> {
    @Override
    public Long convertToDatabaseColumn(Duration duration) {
        return duration == null ? null : duration.toSeconds();
    }

    @Override
    public Duration convertToEntityAttribute(Long durationInSeconds) {
        return durationInSeconds == null ? null : Duration.ofSeconds(durationInSeconds);
    }
}
