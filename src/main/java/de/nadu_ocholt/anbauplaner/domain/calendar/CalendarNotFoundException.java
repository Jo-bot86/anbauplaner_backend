package de.nadu_ocholt.anbauplaner.domain.calendar;

public class CalendarNotFoundException extends RuntimeException {
    public CalendarNotFoundException(Long id) {
        super("Kalender mit ID " + id + " wurde nicht gefunden.");
    }
}
