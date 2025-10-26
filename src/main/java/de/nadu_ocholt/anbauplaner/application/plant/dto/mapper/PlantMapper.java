package de.nadu_ocholt.anbauplaner.application.plant.dto.mapper;


import de.nadu_ocholt.anbauplaner.application.plant.RangeCmDTO;
import de.nadu_ocholt.anbauplaner.application.plant.dto.*;
import de.nadu_ocholt.anbauplaner.domain.plant.GerminationTemperature;
import de.nadu_ocholt.anbauplaner.domain.plant.Plant;
import de.nadu_ocholt.anbauplaner.domain.plant.RangeCm;
import de.nadu_ocholt.anbauplaner.domain.plant.Spacing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlantMapper {
    PlantDTO toDTO(Plant entity);

    Plant toEntity(CreatePlantDTO dto);

    void updateEntity(UpdatePlantDTO dto, @MappingTarget Plant entity);

    default RangeCmDTO toDto(RangeCm range) {
        return new RangeCmDTO(range.getMin(), range.getMax());
    }

    default SpacingDTO toDto(Spacing spacing) {
        return new SpacingDTO(
                toDto(spacing.getRowSpacing()),
                toDto(spacing.getPlantSpacing())
        );
    }

    default GerminationTemperatureDTO toDTO(GerminationTemperature germinationTemperature) {
        return new GerminationTemperatureDTO(germinationTemperature.opt(), germinationTemperature.min(), germinationTemperature.max());
    }

    default RangeCm toEntity(RangeCmDTO dto) {
        if (dto == null) return null;
        return new RangeCm(dto.min(), dto.max());
    }

    default Spacing toEntity(SpacingDTO dto) {
        if (dto == null) return null;
        return new Spacing(
                toEntity(dto.rowSpacing()),
                toEntity(dto.plantSpacing())
        );
    }

    default GerminationTemperature toEntity(GerminationTemperatureDTO dto) {
        if (dto == null) return null;
        return new GerminationTemperature(dto.opt(), dto.min(), dto.max());
    }


}
