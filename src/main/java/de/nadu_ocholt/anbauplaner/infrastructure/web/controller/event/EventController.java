package de.nadu_ocholt.anbauplaner.infrastructure.web.controller.event;

import de.nadu_ocholt.anbauplaner.application.event.EventService;
import de.nadu_ocholt.anbauplaner.application.event.dto.CreateEventDTO;
import de.nadu_ocholt.anbauplaner.application.event.dto.EventDTO;
import de.nadu_ocholt.anbauplaner.application.event.dto.UpdateEventDTO;
import de.nadu_ocholt.anbauplaner.domain.event.exception.EventNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/event")
@RequiredArgsConstructor
public class EventController {

    private EventService eventService;

    @GetMapping
    public List<EventDTO> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        return this.eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody CreateEventDTO eventDTO) {
        EventDTO savedEvent = eventService.createEvent(eventDTO);
        log.info("Es wurde ein neues Event mit dem Titel '{}' angelegt.",
                savedEvent.getTitle());
        return ResponseEntity.ok(savedEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id,
                                                @RequestBody UpdateEventDTO updateEventDTO) {
        EventDTO eventDTO = this.eventService.updateEvent(id, updateEventDTO);
        return ResponseEntity.ok(eventDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        this.eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
