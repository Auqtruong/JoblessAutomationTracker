package com.unemployed.joblessautomationtracker.jobapplication;

import com.unemployed.joblessautomationtracker.security.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 

import java.util.List;

import com.unemployed.joblessautomationtracker.user.*;

import jakarta.validation.Valid;


@Controller
class JobApplicationController {
  private JobApplicationService jobApplicationService;
  private UserService userService;

  Logger logger = LoggerFactory.getLogger(JobApplicationController.class);

  @Autowired
  public JobApplicationController(JobApplicationService jobAppServ, UserService userService) {
    this.jobApplicationService = jobAppServ;
    this.userService = userService;
  }

  @GetMapping("/dashboard/job-apps")
  public String jobApplicationsList(Model model) {
    User user = new User();
    List<JobApplicationDto> jobApplications = jobApplicationService.getAllJobApplications();
    String email = SecurityUtility.getSessionUser();
    if (email != null) {
      user = userService.findByEmail(email);
      model.addAttribute("user", user);
    }
    model.addAttribute("jobApplications", jobApplications);
    // logger.info("Email: "+ user.getEmail());
    // logger.info("Session User: "+ email);
    // logger.info("Job Apps: "+ user.getJobApplications());
    return "/dashboard/job-apps";
  }

  @GetMapping("/dashboard/job-app/{job-app-id}")
  public String jobApplicationDetails(@PathVariable("job-app-id") long jobAppId, Model model) {
    User user = new User();
    JobApplicationDto jobAppDto = jobApplicationService.findJobApplicationById(jobAppId);
    String username = SecurityUtility.getSessionUser();

    if (username != null) {
      user = userService.findByUsername(username);
      model.addAttribute("user", user);
    }
    model.addAttribute("user", user);
    model.addAttribute("JobApplication", jobAppDto);
    return "/dashboard/job-app-details";
  }

  @GetMapping("/dashboard/job-app/new")
  public String jobApplicationCreate(Model model) {
    JobApplication jobApplication = new JobApplication();
    model.addAttribute("jobApplication", jobApplication);
    return "dashboard/job-app-create";
  }

  @PostMapping("/dashboard/job-app/new")
  public String JobApplicationCreate(@Valid @ModelAttribute("jobApplication") JobApplicationDto jobAppDto,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("jobApplication", jobAppDto);
      return "/dashboard/job-app-create";
    }
    jobApplicationService.saveJobApplication(jobAppDto);
    return "redirect:/dashboard/job-apps";
  }

  @GetMapping("/dashboard/job-app/{job-app-id}/edit")
  public String jobApplicationUpdate(@PathVariable("job-app-id") Long jobAppId, Model model) {
    JobApplicationDto jobAppDto = jobApplicationService.findJobApplicationById(jobAppId);
    model.addAttribute("jobApplication", jobAppDto);
    return "dashboard/job-app-create";
  }

  @PostMapping("/dashboard/job-app/{job-app-id}/edit")
  public String JobApplicationUpdate(@PathVariable("job-app-id") Long jobAppId,
      @Valid @ModelAttribute("jobApplication") JobApplicationDto jobAppDto,
      BindingResult result, Model model) {
    if (result.hasErrors())
    {
      model.addAttribute("jobApplication",jobAppDto);
      return "dashboard/job-app-edit";
    }
    jobAppDto.setId(jobAppId);
    jobApplicationService.updateJobApplication(jobAppDto);
    return "redirect:dashboard/job-apps";
  }

  @GetMapping("/dashboard/job-app/{job-app-id}/delete")
  public String jobApplicationDelete(@PathVariable("job-app-id") long jobAppId) {
    jobApplicationService.delete(jobAppId);
    return "redirect:dashboard/job-apps";
  }



}
