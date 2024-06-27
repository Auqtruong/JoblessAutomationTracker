package com.user;

import java.util.Optional;

import org.springframework.data.jpa.Repository.JpaRepository;
import org.springframework.stereotype.Repository;

// user repository extends jpa repo which extends from pagingAndSorting repo which extends from Crud Repo
// Crud Repo contains methods for CRUD operations
@Repository
public interface UserRepository extends JpaRepository<User, String>{

    Optional<User> findByUsername(String username);

}