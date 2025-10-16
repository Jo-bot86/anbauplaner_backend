package de.nadu_ocholt.anbauplaner.application.user.dto;

import de.nadu_ocholt.anbauplaner.application.calendar.dto.CalendarDTO;
import de.nadu_ocholt.anbauplaner.domain.user.Role;

import java.util.List;


public record UserDTO(Long id, String username, String emailAddress, Role role, List<CalendarDTO> calendars) {

}
