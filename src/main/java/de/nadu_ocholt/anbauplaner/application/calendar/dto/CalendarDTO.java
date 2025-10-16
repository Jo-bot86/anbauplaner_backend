package de.nadu_ocholt.anbauplaner.application.calendar.dto;

import de.nadu_ocholt.anbauplaner.application.event.dto.EventDTO;
import de.nadu_ocholt.anbauplaner.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CalendarDTO {

    private Long id;

    private String name;

    private String description;

    private List<EventDTO> events;

    private User owner;
    
}
