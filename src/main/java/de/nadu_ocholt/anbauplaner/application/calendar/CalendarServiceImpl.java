package de.nadu_ocholt.anbauplaner.application.calendar;

import de.nadu_ocholt.anbauplaner.application.calendar.dto.CalendarDTO;
import de.nadu_ocholt.anbauplaner.application.calendar.dto.CreateCalendarDTO;
import de.nadu_ocholt.anbauplaner.application.calendar.dto.UpdateCalendarDTO;
import de.nadu_ocholt.anbauplaner.application.calendar.dto.mapper.CalendarMapper;
import de.nadu_ocholt.anbauplaner.domain.calendar.Calendar;
import de.nadu_ocholt.anbauplaner.domain.calendar.CalendarNotFoundException;
import de.nadu_ocholt.anbauplaner.domain.calendar.CalendarRepository;
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
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository calendarRepository;
    private final CalendarMapper calendarMapper;

    @Override
    public List<CalendarDTO> getAllCalendars() {
        return calendarRepository
                .findAll()
                .stream()
                .map(calendarMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<CalendarDTO> getCalendarById(Long id) {
        return calendarRepository.findById(id).map(calendarMapper::toDTO);
    }

    @Override
    public CalendarDTO createCalendar(CreateCalendarDTO createCalendarDTO) {
        Calendar calendar = calendarMapper.toEntity(createCalendarDTO);
        return calendarMapper.toDTO(calendarRepository.save(calendar));
    }

    @Override
    public CalendarDTO updateCalendar(Long id, UpdateCalendarDTO updateCalendarDTO) {
        Calendar calendar = calendarRepository.findById(id).orElseThrow(() -> new CalendarNotFoundException(id));
        this.calendarMapper.updateEntity(updateCalendarDTO, calendar);
        return this.calendarMapper.toDTO(calendarRepository.save(calendar));
    }

    @Override
    public void deleteCalendar(Long id) {
        if (this.calendarRepository.findById(id).isPresent()) {
            this.calendarRepository.deleteById(id);
        } else {
            throw new CalendarNotFoundException(id);
        }
    }
}
