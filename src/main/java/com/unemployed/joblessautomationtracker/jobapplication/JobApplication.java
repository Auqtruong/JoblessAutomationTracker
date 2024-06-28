package com.unemployed.joblessautomationtracker.jobapplication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import com.unemployed.joblessautomationtracker.user.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "job_applications")
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
}
