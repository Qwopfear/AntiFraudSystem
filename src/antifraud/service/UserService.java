package antifraud.service;

import antifraud.jpa.UserRepository;
import antifraud.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{

    User save(User user);

    User findByUsername(String username);

    List<User> findAll();

    void deleteByUsername(String username);


}
