package antifraud.controller.responce;

import antifraud.pojo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserResponse {

    public static ResponseEntity<Object> createResponse(User user, HttpStatus httpStatus) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("id", user.getId());
        body.put("name", user.getName());
        body.put("username", user.getUsername());

        return new ResponseEntity<>(body,httpStatus);
    }

    public static ResponseEntity<Object> createResponse(List<User> users, HttpStatus httpStatus) {
        List<Map<String, Object>> body = new ArrayList<>();

        for (User user : users) {
            Map<String, Object> bodyElement = new LinkedHashMap<>();
            bodyElement.put("id", user.getId());
            bodyElement.put("name", user.getName());
            bodyElement.put("username", user.getUsername());
            body.add(bodyElement);
        }

        return new ResponseEntity<>(body,httpStatus);
    }
}
