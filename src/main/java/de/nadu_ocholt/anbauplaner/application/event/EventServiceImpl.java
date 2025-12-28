package de.nadu_ocholt.anbauplaner.application.event;

import de.nadu_ocholt.anbauplaner.application.event.dto.CreateEventDTO;
import de.nadu_ocholt.anbauplaner.application.event.dto.EventDTO;
import de.nadu_ocholt.anbauplaner.application.event.dto.UpdateEventDTO;
import de.nadu_ocholt.anbauplaner.application.event.dto.mapper.EventMapper;
import de.nadu_ocholt.anbauplaner.domain.event.Event;
import de.nadu_ocholt.anbauplaner.domain.event.EventRepository;
import de.nadu_ocholt.anbauplaner.domain.event.exception.EventNotFoundException;
import de.nadu_ocholt.anbauplaner.domain.plant.exception.PlantNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;


    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository
                .findAll()
                .stream()
                .map(eventMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<EventDTO> getEventById(Long id) {
        return eventRepository.findById(id)
                .map(eventMapper::toDTO);
    }

    @Override
    public EventDTO createEvent(CreateEventDTO eventDTO) {
        Event entity = eventMapper.toEntity(eventDTO);
        return eventMapper.toDTO(eventRepository.save(entity));
    }

    @Override
    public EventDTO updateEvent(Long id, UpdateEventDTO eventDTO) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
        this.eventMapper.updateEntity(eventDTO, event);
        return this.eventMapper.toDTO(event);
    }

    @Override
    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new PlantNotFoundException(id);
        }
        eventRepository.deleteById(id);
    }
}
