package de.nadu_ocholt.anbauplaner.domain.plant;

import jakarta.persistence.Embeddable;

@Embeddable
public record GerminationTemperature(Double opt, Double min, Double max) {

}
