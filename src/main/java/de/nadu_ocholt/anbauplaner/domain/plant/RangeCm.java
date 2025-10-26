package de.nadu_ocholt.anbauplaner.domain.plant;

import de.nadu_ocholt.anbauplaner.domain.shared.vaildidation.ValidRange;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Getter
@ValidRange
@Embeddable
public class RangeCm implements Serializable {

    private Integer min;
    private Integer max;

    protected RangeCm() {
    }

    public RangeCm(Integer min, Integer max) {
        if (min == null || max == null) throw new IllegalArgumentException("min/max not null");
        if (min > max) throw new IllegalArgumentException("min <= max");
        this.min = min;
        this.max = max;
    }

    public boolean isSingleValue() {
        return min.equals(max);
    }

    @Override
    public String toString() {
        return isSingleValue() ? String.valueOf(min) : min + "–" + max;
    }
}

