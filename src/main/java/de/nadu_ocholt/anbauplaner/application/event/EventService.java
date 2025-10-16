package de.nadu_ocholt.anbauplaner.application.event;

import de.nadu_ocholt.anbauplaner.application.event.dto.CreateEventDTO;
import de.nadu_ocholt.anbauplaner.application.event.dto.EventDTO;
import de.nadu_ocholt.anbauplaner.application.event.dto.UpdateEventDTO;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<EventDTO> getAllEvents();

    Optional<EventDTO> getEventById(Long id);

    EventDTO createEvent(CreateEventDTO eventDTO);

    EventDTO updateEvent(Long id, UpdateEventDTO eventDTO);

    void deleteEvent(Long id);
}
