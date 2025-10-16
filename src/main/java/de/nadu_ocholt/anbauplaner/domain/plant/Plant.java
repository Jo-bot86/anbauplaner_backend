package de.nadu_ocholt.anbauplaner.domain.plant;

import de.nadu_ocholt.anbauplaner.domain.event.Event;
import de.nadu_ocholt.anbauplaner.shared.persistence.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "plants")
public class Plant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;        // z.B. "Weißkohl"

    @NotNull
    private String category;    // z.B. "Kohlgemüse"


    private String sowingPeriod;
    private String harvestPeriod;

    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> event;

}
