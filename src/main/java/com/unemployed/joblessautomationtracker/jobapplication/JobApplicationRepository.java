package com.unemployed.joblessautomationtracker.jobapplication;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>{
  Optional<JobApplication> findById(Long id);
}
