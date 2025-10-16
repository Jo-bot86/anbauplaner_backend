package de.nadu_ocholt.anbauplaner.application.plant.dto;

import de.nadu_ocholt.anbauplaner.application.event.dto.EventDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlantDTO {
    private Long id;

    private String name;

    private String category;

    private String sowingPeriod;

    private String harvestPeriod;

    private List<EventDTO> event;
}
