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

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "users")
@Data // @Data should auto-generate getters and setters
@NoArgsConstructor
@AllArgsConstructor
public class User{

  @Id // primary key annotation
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long Id;
  @Column(nullable = false, unique = true)
  private String email;
  @Column(nullable = false)
  private String password;
  private String username;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "users_roles", joinColumns = {
      @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "role_id", referencedColumnName = "id") })
  private List<Role> roles = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy", cascade = CascadeType.ALL)
  private List<JobApplication> jobApplications = new ArrayList<>();

}
