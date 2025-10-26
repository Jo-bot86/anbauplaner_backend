package de.nadu_ocholt.anbauplaner.application.plant;

import de.nadu_ocholt.anbauplaner.application.plant.dto.CreatePlantDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.PlantDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.UpdatePlantDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.mapper.PlantMapper;
import de.nadu_ocholt.anbauplaner.domain.plant.Plant;
import de.nadu_ocholt.anbauplaner.domain.plant.PlantRepository;
import de.nadu_ocholt.anbauplaner.domain.plant.exception.PlantAlreadyExistsException;
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
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;
    private final PlantMapper plantMapper;

    @Override
    public List<PlantDTO> getAllPlants() {
        return plantRepository.findAll().stream()
                .map(plantMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<PlantDTO> getPlantById(Long id) {
        return plantRepository.findById(id)
                .map(plantMapper::toDTO);
    }

    @Override
    public PlantDTO createPlant(CreatePlantDTO plantDTO) {
        log.info("Creating new plant: {}", plantDTO.name());

        if (this.plantRepository.existsByName(plantDTO.name())) {
            throw new PlantAlreadyExistsException(plantDTO.name());
        }

        Plant entity = plantMapper.toEntity(plantDTO);
        return plantMapper.toDTO(plantRepository.save(entity));
    }

    @Override
    public PlantDTO updatePlant(Long id, UpdatePlantDTO plantDTO) {
        Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> new PlantNotFoundException(id));
        this.plantMapper.updateEntity(plantDTO, plant);
        return this.plantMapper.toDTO(this.plantRepository.save(plant));
    }

    @Override
    public void deletePlant(Long id) {
        if (!plantRepository.existsById(id)) {
            throw new PlantNotFoundException(id);
        }
        plantRepository.deleteById(id);
    }
}
