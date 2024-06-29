package com.unemployed.joblessautomationtracker.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data //@Data should auto-generate getters and setters
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id //primary key annotation
    @Column(name = "u_user")
    private String username;

    @Column(name = "u_pass")
    private String password;
}


