package com.unemployed.joblessautomationtracker.security;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unemployed.joblessautomationtracker.user.UserRepository;

@Service
public class AuthUserService implements UserDetailsService {

  private final UserRepository repository;

  @Autowired
  public AuthUserService(final UserRepository repository) {
    this.repository = repository;
  }

  // TO IMPLEMENT: implement from interface UserDetailsService (for spring
  // security)
  @Override
  public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {

    // try to find user in db via username
    com.unemployed.joblessautomationtracker.user.User user = repository.findByEmail(email);
    if (user != null) {
      User authUser = new User(
          user.getEmail(),
          user.getPassword(),
          user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getType()))
              .collect(Collectors.toList()));
      return authUser;
    } else {
      throw new UsernameNotFoundException("Invalid username or password");
    }

  }

}
