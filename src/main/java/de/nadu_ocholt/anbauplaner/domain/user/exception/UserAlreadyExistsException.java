package de.nadu_ocholt.anbauplaner.domain.user.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String email) {
        super("Ein Benutzer mit der E-Mail-Adresse '" + email + "' existiert bereits.");
    }
}
