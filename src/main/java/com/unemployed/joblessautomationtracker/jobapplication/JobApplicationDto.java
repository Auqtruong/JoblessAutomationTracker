package com.unemployed.joblessautomationtracker.jobapplication;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;

import com.unemployed.joblessautomationtracker.user.User;

@Data
@Builder
public class JobApplicationDto {
  private Long id;
  @NotEmpty(message = "Position cannot be empty")
  private String positionTitle;
  @NotEmpty(message = "Company cannot be empty")
  private String companyTitle;
  @NotEmpty(message = "Submission Date cannot be empty")
  private LocalDateTime submittedOn;
  private LocalDateTime createdOn;
  private LocalDateTime updatedOn;
  private User createdBy;
  private String applicationUrl;
  private String contactInfo;
  private String response;
  private String workType; 
  private String status; 
  private String location;
  private String salary;
  private String jobPlatform; 
}
/*
 *
public class JobApplication {
  @Id
  @GeneratedValue
  private Long id;

  private String positionTitle;
  private LocalDateTime submittedOn;
  private String companyTitle;

  @CreationTimestamp
  private LocalDateTime createdOn;

  @UpdateTimestamp
  private LocalDateTime updatedOn;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="created_by",nullable=false)
  private User createdBy;
  
  private String applicationUrl;
  private String contactInfo;
  private String response;
  private String workType; // Hybrid/On-site/Remote
  private String status; // Interview Process/Stage/Status
  private String location;
  private String salary;
  private String jobPlatform; // LinkedIn/Indeed/etc.

}
*/
