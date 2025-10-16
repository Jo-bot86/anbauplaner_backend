package de.nadu_ocholt.anbauplaner.application.plant.dto.mapper;


import de.nadu_ocholt.anbauplaner.application.plant.dto.CreatePlantDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.PlantDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.UpdatePlantDTO;
import de.nadu_ocholt.anbauplaner.domain.plant.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlantMapper {
    PlantDTO toDTO(Plant entity);

    Plant toEntity(CreatePlantDTO dto);

    void updateEntity(UpdatePlantDTO dto, @MappingTarget Plant entity);
}
