package de.nadu_ocholt.anbauplaner.infrastructure.web.advice;

import de.nadu_ocholt.anbauplaner.domain.user.exception.UserAlreadyExistsException;
import de.nadu_ocholt.anbauplaner.domain.user.exception.UserNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFound(UserNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problem.setTitle("User not found");
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail handleAccessDenied(AccessDeniedException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.FORBIDDEN);
        problem.setTitle("Access denied");
        problem.setDetail("Du hast keine Berechtigung, diese Aktion auszuführen.");
        problem.setType(URI.create("https://nadu_ocholt.anbauplaner" +
                                           ".de/errors/access-denied"));
        return problem;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationError(MethodArgumentNotValidException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Validation failed");
        problem.setType(URI.create("https://nadu_ocholt.anbauplaner" +
                                           ".de/errors/validation-failed"));

        var fieldErrors = ex.getBindingResult()
                            .getFieldErrors()
                            .stream()
                            .map(f -> f.getField() + ": " + f.getDefaultMessage())
                            .toList();

        problem.setDetail("Es sind Validierungsfehler aufgetreten.");
        problem.setProperty("errors", fieldErrors);

        return problem;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ProblemDetail handleConstraintViolation(ConstraintViolationException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Constraint violation");
        problem.setDetail(ex.getMessage());
        problem.setType(URI.create("https://nadu_ocholt.anbauplaner" +
                                           ".de/errors/constraint-violation"));
        return problem;
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ProblemDetail handleUserAlreadyExists(UserAlreadyExistsException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problem.setTitle("User already exists");
        problem.setDetail(ex.getMessage());
        problem.setType(URI.create("https://nadu_ocholt.anbauplaner" +
                                           ".de/errors/user-already-exists"));
        return problem;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGenericError(Exception ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problem.setTitle("Internal server error");
        problem.setDetail("Ein unerwarteter Fehler ist aufgetreten.");
        problem.setType(URI.create("https://nadu_ocholt.anbauplaner" +
                                           ".de/errors/internal-server-error"));
        return problem;
    }
}
