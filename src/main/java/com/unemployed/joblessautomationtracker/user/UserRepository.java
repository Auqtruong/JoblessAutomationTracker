package com.unemployed.joblessautomationtracker.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// user repository extends jpa repo which extends from pagingAndSorting repo which extends from Crud Repo
// Crud Repo contains methods for CRUD operations
@Repository
public interface UserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
    User findByEmail(String email);
}
