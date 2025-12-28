package de.nadu_ocholt.anbauplaner.infrastructure.web.controller.plant;

import de.nadu_ocholt.anbauplaner.application.plant.PlantService;
import de.nadu_ocholt.anbauplaner.application.plant.dto.CreatePlantDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.PlantDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.UpdatePlantDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/plant")
@RequiredArgsConstructor
public class PlantController {
    private final PlantService plantService;

    @GetMapping
    public List<PlantDTO> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/{id}")
    public PlantDTO getPlantById(@PathVariable Long id) {
        return plantService.getPlantById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found")); // oder PlantNotFoundException
    }

    @PostMapping
    public PlantDTO createPlant(@RequestBody CreatePlantDTO plantDTO) {
        return plantService.createPlant(plantDTO);
    }

    @PutMapping("/{id}")
    public PlantDTO updatePlant(@PathVariable Long id,
                                @RequestBody UpdatePlantDTO plantDTO) {
        return plantService.updatePlant(id, plantDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
    }
}
