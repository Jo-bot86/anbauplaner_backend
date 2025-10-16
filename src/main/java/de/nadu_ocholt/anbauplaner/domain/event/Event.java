package de.nadu_ocholt.anbauplaner.domain.event;

import de.nadu_ocholt.anbauplaner.domain.calendar.Calendar;
import de.nadu_ocholt.anbauplaner.domain.plant.Plant;
import de.nadu_ocholt.anbauplaner.shared.persistence.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="events")
public class Event extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;
    private String description;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    @ManyToOne
    @JoinColumn(name="plant_id")
    private Plant plant;
}
