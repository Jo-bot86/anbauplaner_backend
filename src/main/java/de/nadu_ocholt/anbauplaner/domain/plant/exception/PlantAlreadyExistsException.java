package de.nadu_ocholt.anbauplaner.domain.plant.exception;

public class PlantAlreadyExistsException extends RuntimeException {
    public PlantAlreadyExistsException(String name) {
        super("Pflanze mit Namen '" + name + "' existiert bereits.");
    }
}
