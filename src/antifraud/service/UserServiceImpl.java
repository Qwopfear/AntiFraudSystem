package antifraud.service;

import antifraud.exceptions.NotUniqueUsernameException;
import antifraud.jpa.UserRepository;
import antifraud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) throws NotUniqueUsernameException {

        if (userRepository.findAll().stream().anyMatch(el -> el.getUsername().equals(user.getUsername()))){
            throw new NotUniqueUsernameException("User: " + user.getUsername() + " already exist" );
        }
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository
                .findAll()
                .stream()
                .filter(el -> el.getUsername().equals(username))
                .findFirst().orElse(null);
       if (user == null) {
           throw new UsernameNotFoundException("Not found" + username);
       }
        return user;
    }

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.delete(findByUsername(username));

    }



}
