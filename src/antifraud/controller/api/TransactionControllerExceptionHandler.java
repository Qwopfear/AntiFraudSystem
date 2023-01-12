package antifraud.controller.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionControllerExceptionHandler {

    @ExceptionHandler({NullPointerException.class,IllegalArgumentException.class})
    public ResponseEntity<Object> npeHandler(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
