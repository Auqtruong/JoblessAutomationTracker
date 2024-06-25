package com.unemployed.joblessautomationtracker.jobapplication;

import java.util.List;

public interface JobApplicationService {
  List<JobApplicationDto> getAllJobApplications();
  JobApplication saveJobApplication(JobApplicationDto jobAppDto);
  JobApplicationDto findJobApplicationById(Long jobAppId);
  void updateJobApplication(JobApplicationDto jobAppDto);
  void delete(Long jobAppId);
}
