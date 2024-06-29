package com.unemployed.joblessautomationtracker.user;

import com.unemployed.joblessautomationtracker.role.*;
import com.unemployed.joblessautomationtracker.jobapplication.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "users")
@Data // @Data should auto-generate getters and setters
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

  @Id // primary key annotation
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long Id;

  @Column(name = "u_user")
  private String username;

  @Column(name = "u_pass")
  private String password;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "users_roles", joinColumns = {
      @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "role_id", referencedColumnName = "id") })
  private List<Role> roles = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy", cascade = CascadeType.ALL)
  private List<JobApplication> jobApplications = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getType())).collect(Collectors.toList());
  }

}
