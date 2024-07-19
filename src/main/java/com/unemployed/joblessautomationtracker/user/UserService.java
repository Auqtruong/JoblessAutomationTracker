package com.unemployed.joblessautomationtracker.user;

//security imports will not be an issue after dependencies are uncommented in pom.xml
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

  private final UserRepository repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepository repository, PasswordEncoder passEnc) {
    this.repository = repository;
    this.passwordEncoder = passEnc;
  }

  // function to save user
  public User save(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return repository.save(user);
  }

  // function to get username
  public User findByUsername(String username) {
    return repository.findByUsername(username);
  }

  // function to get username
  public User findByEmail(String email) {
    return repository.findByEmail(email);
  }

}
