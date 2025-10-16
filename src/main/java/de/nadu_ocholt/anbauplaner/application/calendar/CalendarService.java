package de.nadu_ocholt.anbauplaner.application.calendar;

import de.nadu_ocholt.anbauplaner.application.calendar.dto.CalendarDTO;
import de.nadu_ocholt.anbauplaner.application.calendar.dto.CreateCalendarDTO;
import de.nadu_ocholt.anbauplaner.application.calendar.dto.UpdateCalendarDTO;

import java.util.List;
import java.util.Optional;

public interface CalendarService {
    List<CalendarDTO> getAllCalendars();

    Optional<CalendarDTO> getCalendarById(Long id);

    CalendarDTO createCalendar(CreateCalendarDTO createCalendarDTO);

    CalendarDTO updateCalendar(Long id, UpdateCalendarDTO updateCalendarDTO);

    void deleteCalendar(Long id);
}
