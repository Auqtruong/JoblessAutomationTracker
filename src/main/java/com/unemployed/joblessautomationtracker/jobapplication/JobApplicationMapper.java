package com.unemployed.joblessautomationtracker.jobapplication;

import java.util.stream.Collectors;

public class JobApplicationMapper {
  public static JobApplication mapToJobApplication(JobApplicationDto jobApp) {
    JobApplication jobApplication = JobApplication.builder()
      .id(jobApp.getId())
      .positionTitle(jobApp.getPositionTitle())
      .submittedOn(jobApp.getSubmittedOn())
      .companyTitle(jobApp.getCompanyTitle())
      .createdOn(jobApp.getCreatedOn())
      .updatedOn(jobApp.getUpdatedOn())
      .build();
    return jobApplication;
  }

  public static JobApplicationDto mapToJobApplicationDto(JobApplication jobApp) {
    JobApplicationDto jobApplicationDto = JobApplicationDto.builder()
      .id(jobApp.getId())
      .positionTitle(jobApp.getPositionTitle())
      .submittedOn(jobApp.getSubmittedOn())
      .companyTitle(jobApp.getCompanyTitle())
      .createdOn(jobApp.getCreatedOn())
      .updatedOn(jobApp.getUpdatedOn())
      .build();
    return jobApplicationDto;
  }

}
