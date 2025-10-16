package de.nadu_ocholt.anbauplaner.application.calendar.dto.mapper;

import de.nadu_ocholt.anbauplaner.application.calendar.dto.CalendarDTO;
import de.nadu_ocholt.anbauplaner.application.calendar.dto.CreateCalendarDTO;
import de.nadu_ocholt.anbauplaner.application.calendar.dto.UpdateCalendarDTO;
import de.nadu_ocholt.anbauplaner.domain.calendar.Calendar;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CalendarMapper {

    CalendarDTO toDTO(Calendar entity);

    Calendar toEntity(CreateCalendarDTO dto);

    void updateEntity(UpdateCalendarDTO dto, @MappingTarget Calendar entity);
}
