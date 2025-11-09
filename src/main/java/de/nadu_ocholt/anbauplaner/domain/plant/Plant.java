package de.nadu_ocholt.anbauplaner.domain.plant;

import de.nadu_ocholt.anbauplaner.domain.event.Event;
import de.nadu_ocholt.anbauplaner.domain.plant.converter.PeriodToLongConverter;
import de.nadu_ocholt.anbauplaner.shared.persistence.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Period;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "plants")
public class Plant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String variety; // z.B. Floris

    @NotNull
    private String name;        // z.B. "Brokkoli"

    @NotNull
    private String genus;    // z.B. "Kohl"

    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> event;

    @Convert(converter = PeriodToLongConverter.class)
    private Period developmentDuration;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "opt", column = @Column(name = "germination_temperature_celsius_opt")),
            @AttributeOverride(name = "min", column = @Column(name = "germination_temperature_celsius_min")),
            @AttributeOverride(name = "max", column = @Column(name = "germination_temperature_celsius_max"))
    })
    private GerminationTemperature germinationTemperature;

    @Embedded
    private Spacing spacing;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "min", column = @Column(name = "seeding_depth_cm_min")),
            @AttributeOverride(name = "max", column = @Column(name = "seeding_depth_cm_max"))
    })
    private RangeCm seedingDepth;
}
