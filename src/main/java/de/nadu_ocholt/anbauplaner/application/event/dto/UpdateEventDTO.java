package de.nadu_ocholt.anbauplaner.application.event.dto;

import de.nadu_ocholt.anbauplaner.application.calendar.dto.CalendarDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.PlantDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateEventDTO {
    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private CalendarDTO calendar;

    private PlantDTO plant;
}
