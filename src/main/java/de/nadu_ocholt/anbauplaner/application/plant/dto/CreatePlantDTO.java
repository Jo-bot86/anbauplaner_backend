package de.nadu_ocholt.anbauplaner.application.plant.dto;

import de.nadu_ocholt.anbauplaner.application.event.dto.EventDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreatePlantDTO {

    @NotBlank
    private String name;

    private String category;

    private String sowingPeriod;

    private String harvestPeriod;

    private List<EventDTO> event;
}
