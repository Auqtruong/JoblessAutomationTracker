package com.unemployed.joblessautomationtracker.jobapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
class JobApplicationController {
  private JobApplicationService jobApplicationService;

  @Autowired
  public JobApplicationController(JobApplicationService jobAppServ){
    this.jobApplicationService = jobAppServ;
  }

  @GetMapping("/job-applications")
	public String listJobApplications(Model model) {
    List<JobApplicationDto> jobApplications = jobApplicationService.getAllJobApplications();
    model.addAttribute("job_applications", jobApplications);
    return "job-applications";
	}


}
