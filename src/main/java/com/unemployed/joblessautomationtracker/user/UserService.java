package com.unemployed.joblessautomationtracker.user;

import java.util.Optional;
import static java.util.Collections.singletonList;


//security imports will not be an issue after dependencies are uncommented in pom.xml
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService {
    
    private final UserRepository repository;

    @Autowired
    public UserService(final UserRepository repository){
        this.repository = repository;
    }

    // //TO IMPLEMENT: implement from interface UserDetailsService (for spring security)
    // @Override
    // public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    //
    //     //try to find user in db via username
    //     Optional<User> userRecord = repository.findByUsername(username);
    //     
    //     //user isn't in DB
    //     if(userRecord.isEmpty()){
    //         throw new UsernameNotFoundException("User " + username + " not found");
    //     }
    //
    //     User user = userRecord.get();
    //
    //     //return user data in a Singleton List since each user should only have 1 immutable instance of their account
    //     return new org.springframework.security.core.userdetails.User(
    //         user.getUsername(), 
    //         user.getPassword(), 
    //         singletonList(new SimpleGrantedAuthority(   "ROLE_USER"))
    //     );
    // }

    //function to save user
    public User save(final User user){
        return repository.save(user);
    }



}
