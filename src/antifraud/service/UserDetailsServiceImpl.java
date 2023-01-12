package antifraud.service;


import antifraud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        for (User u: userService.findAll()
             ) {
            if (u.getUsername().toUpperCase(Locale.ROOT).equals(username.toUpperCase()))
                return new UserDetailsImpl(userService.findByUsername(username));
        }

        throw new UsernameNotFoundException("Username:" + username + " Not Found");

    }

    public User createUser(UserDetailsImpl user) {
        return userService.save(user.getUser());
    }

}
