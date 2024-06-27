package com.user;

import java.util.Optional;

//security imports will not be an issue after dependencies are uncommented in pom.xml
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService implements UserDetailsService{
    
    private final UserRepository repository;

    @Autowired
    //constructor
    public UserService(final UserRepository repository){
        this.repository = repository;
    }

    //TO IMPLEMENT: implement from interface UserDetailsService (for spring security)
    public UserDetail loadUserByUsername(final String username) throws UsernameNotFoundException {

        //try to find user in db via username
        User user = repository.findByUsername(username);
        
        //user isn't in DB
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        //return user data in a Singleton List since each user should only have 1 immutable instance of their account
    }

    //function to save user
    public User save(final User user){
        return repository.save(user);
    }

}
