package main.java.com.user;

import org.springframework.stereo.Service;
import org.springframework.beans.factory.annotation.Autowired;

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

    }

    //function to save user
    public User save(final User user){
        return repository.save(user);
    }

}
