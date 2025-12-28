package de.nadu_ocholt.anbauplaner.domain.event.exception;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("Event mit ID " + id + " wurde nicht gefunden.");
    }
}
