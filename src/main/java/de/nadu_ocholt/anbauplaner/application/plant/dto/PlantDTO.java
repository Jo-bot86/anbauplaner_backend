package de.nadu_ocholt.anbauplaner.application.plant.dto;

import de.nadu_ocholt.anbauplaner.application.event.dto.EventDTO;
import de.nadu_ocholt.anbauplaner.application.plant.RangeCmDTO;

import java.time.Duration;
import java.util.List;

public record PlantDTO(Long id,
                       String variety,
                       String name,
                       String genus,
                       List<EventDTO> event,
                       Duration developmentDuration,
                       GerminationTemperatureDTO germinationTemperature,
                       SpacingDTO spacing,
                       RangeCmDTO seedingDepth) {

}
