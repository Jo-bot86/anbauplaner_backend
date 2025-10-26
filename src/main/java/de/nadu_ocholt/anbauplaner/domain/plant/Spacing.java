package de.nadu_ocholt.anbauplaner.domain.plant;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Embeddable
public class Spacing {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "min", column = @Column(name = "row_spacing_cm_min")),
            @AttributeOverride(name = "max", column = @Column(name = "row_spacing_cm_max")),
    })
    private RangeCm rowSpacing;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "min", column = @Column(name = "plant_spacing_cm_min")),
            @AttributeOverride(name = "max", column = @Column(name = "plant_spacing_cm_max"))
    })
    private RangeCm plantSpacing;

    @Override
    public String toString() {
        return rowSpacing + " × " + plantSpacing + " cm";
    }
}
