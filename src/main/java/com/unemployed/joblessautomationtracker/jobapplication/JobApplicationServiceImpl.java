package com.unemployed.joblessautomationtracker.jobapplication;

import java.util.List;
import java.util.stream.Collectors;

import static com.unemployed.joblessautomationtracker.jobapplication.JobApplicationMapper.mapToJobApplication;
import static com.unemployed.joblessautomationtracker.jobapplication.JobApplicationMapper.mapToJobApplicationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationServiceImpl implements JobApplicationService{

  private JobApplicationRepository jobApplicationRepository;

  @Autowired
  public JobApplicationServiceImpl(JobApplicationRepository jobAppRepo){
    this.jobApplicationRepository = jobAppRepo;
  }
  
  @Override
  public List<JobApplicationDto> getAllJobApplications(){
    List<JobApplication> jobApps = jobApplicationRepository.findAll();
    return jobApps.stream()
      .map((jobApplication) -> mapToJobApplicationDto(jobApplication))
      .collect(Collectors.toList());
  }

  @Override
  public JobApplication saveJobApplication(JobApplicationDto jobAppDto){
    JobApplication jobApp = mapToJobApplication(jobAppDto);
    return jobApplicationRepository.save(jobApp);
  }

  @Override
  public JobApplicationDto findJobApplicationById(Long jobAppId){
    JobApplication jobApp = jobApplicationRepository.findById(jobAppId).get();
    return mapToJobApplicationDto(jobApp);
  }

  @Override
  public void updateJobApplication(JobApplicationDto jobAppDto){
    JobApplication jobApp = mapToJobApplication(jobAppDto);
    jobApplicationRepository.save(jobApp);
  }

  @Override
  public void delete(Long jobAppId){
    jobApplicationRepository.deleteById(jobAppId);
  }

}
