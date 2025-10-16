package de.nadu_ocholt.anbauplaner.domain.plant.exception;

public class PlantNotFoundException extends RuntimeException {
    public PlantNotFoundException(Long id) {
        super("Pflanze mit ID " + id + " wurde nicht gefunden.");
    }
}
