package antifraud.exceptions;

import org.springframework.security.core.AuthenticationException;

public class NotUniqueUsernameException extends AuthenticationException {

    public NotUniqueUsernameException(String message) {
        super(message);
    }
}
