package de.nadu_ocholt.anbauplaner.domain.user.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super("User with ID " + id + " not found");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
