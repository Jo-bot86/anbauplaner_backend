package de.nadu_ocholt.anbauplaner.application.calendar.dto;

import de.nadu_ocholt.anbauplaner.application.event.dto.CreateEventDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateCalendarDTO {
    private String name;

    private String description;

    private List<CreateEventDTO> events;
}
