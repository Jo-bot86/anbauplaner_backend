package de.nadu_ocholt.anbauplaner.application.plant.dto;

import de.nadu_ocholt.anbauplaner.application.event.dto.EventDTO;
import de.nadu_ocholt.anbauplaner.application.plant.RangeCmDTO;

import java.time.Period;
import java.util.List;

public record CreatePlantDTO(String variety,
                             String name,
                             String genus,
                             List<EventDTO> event,
                             Period developmentDuration,
                             GerminationTemperatureDTO germinationTemperature,
                             SpacingDTO spacing,
                             RangeCmDTO seedingDepth
) {

}
