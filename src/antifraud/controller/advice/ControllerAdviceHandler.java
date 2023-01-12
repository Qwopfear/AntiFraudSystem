package antifraud.controller.advice;

import antifraud.exceptions.NotUniqueUsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerAdviceHandler {


    @ExceptionHandler({UsernameNotFoundException.class})
    protected ResponseEntity<Object> usernameNotFoundExceptionHandler() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NotUniqueUsernameException.class})
    protected ResponseEntity<Object> notUniqueUsernameExceptionHandler() {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
