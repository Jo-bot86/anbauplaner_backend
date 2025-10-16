package de.nadu_ocholt.anbauplaner.application.plant;

import de.nadu_ocholt.anbauplaner.application.plant.dto.CreatePlantDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.PlantDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.UpdatePlantDTO;

import java.util.List;
import java.util.Optional;

public interface PlantService {
    List<PlantDTO> getAllPlants();
    Optional<PlantDTO> getPlantById(Long id);
    PlantDTO createPlant(CreatePlantDTO plantDTO);
    PlantDTO updatePlant(Long id, UpdatePlantDTO plantDTO);
    void deletePlant(Long id);
}
