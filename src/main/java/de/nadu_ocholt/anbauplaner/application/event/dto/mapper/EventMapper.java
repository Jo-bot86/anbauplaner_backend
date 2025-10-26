package de.nadu_ocholt.anbauplaner.application.event.dto.mapper;

import de.nadu_ocholt.anbauplaner.application.event.dto.CreateEventDTO;
import de.nadu_ocholt.anbauplaner.application.event.dto.EventDTO;
import de.nadu_ocholt.anbauplaner.application.event.dto.UpdateEventDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.mapper.PlantMapper;
import de.nadu_ocholt.anbauplaner.domain.event.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {PlantMapper.class})
public interface EventMapper {

    EventDTO toDTO(Event entity);

    Event toEntity(CreateEventDTO dto);

    void updateEntity(UpdateEventDTO dto, @MappingTarget Event entity);
}
