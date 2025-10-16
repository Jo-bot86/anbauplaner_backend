package de.nadu_ocholt.anbauplaner.application.event.dto;

import de.nadu_ocholt.anbauplaner.domain.calendar.Calendar;
import de.nadu_ocholt.anbauplaner.domain.plant.Plant;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateEventDTO {

    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Calendar calendar;

    private Plant plant;
}
