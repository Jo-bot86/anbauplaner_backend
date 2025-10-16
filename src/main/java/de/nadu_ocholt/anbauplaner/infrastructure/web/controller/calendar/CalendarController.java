package de.nadu_ocholt.anbauplaner.infrastructure.web.controller.calendar;

import de.nadu_ocholt.anbauplaner.application.calendar.CalendarService;
import de.nadu_ocholt.anbauplaner.application.calendar.dto.CalendarDTO;
import de.nadu_ocholt.anbauplaner.application.calendar.dto.CreateCalendarDTO;
import de.nadu_ocholt.anbauplaner.application.calendar.dto.UpdateCalendarDTO;
import de.nadu_ocholt.anbauplaner.domain.calendar.CalendarNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping
    public List<CalendarDTO> getAllCalendar() {
        return calendarService.getAllCalendars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalendarDTO> getCalendarById(@PathVariable Long id) {
        return this.calendarService.getCalendarById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new CalendarNotFoundException(id));
    }

    @PostMapping
    public ResponseEntity<CalendarDTO> createCalendar(@RequestBody CreateCalendarDTO createCalendarDTO) {
        CalendarDTO savedCalendar = calendarService.createCalendar(createCalendarDTO);
        log.info("Es wurde ein Kalender mit dem Namen '{}'  angelegt",
                savedCalendar.getName());
        return ResponseEntity.ok(savedCalendar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalendarDTO> updateCalendar(@PathVariable Long id,
                                                      @RequestBody UpdateCalendarDTO updateCalendarDTO) {
        CalendarDTO calendarDTO = this.calendarService.updateCalendar(id, updateCalendarDTO);
        return ResponseEntity.ok(calendarDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalendar(@PathVariable Long id) {
        this.calendarService.deleteCalendar(id);
        return ResponseEntity.noContent().build();
    }
}
