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
        .createdBy(jobApp.getCreatedBy())
        .applicationUrl(jobApp.getApplicationUrl())
        .contactInfo(jobApp.getContactInfo())
        .response(jobApp.getResponse())
        .workType(jobApp.getWorkType())
        .status(jobApp.getStatus())
        .location(jobApp.getLocation())
        .salary(jobApp.getSalary())
        .jobPlatform(jobApp.getJobPlatform())
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
        .createdBy(jobApp.getCreatedBy())
        .applicationUrl(jobApp.getApplicationUrl())
        .contactInfo(jobApp.getContactInfo())
        .response(jobApp.getResponse())
        .workType(jobApp.getWorkType())
        .status(jobApp.getStatus())
        .location(jobApp.getLocation())
        .salary(jobApp.getSalary())
        .jobPlatform(jobApp.getJobPlatform())
        .build();
    return jobApplicationDto;
  }

}

