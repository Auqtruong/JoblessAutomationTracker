package com.unemployed.joblessautomationtracker.jobapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import com.unemployed.joblessautomationtracker.user.*;

import jakarta.validation.Valid;

@Controller
class JobApplicationController {
  private JobApplicationService jobApplicationService;
  private UserService userService;

  @Autowired
  public JobApplicationController(JobApplicationService jobAppServ, UserService userService) {
    this.jobApplicationService = jobAppServ;
    this.userService = userService;
  }

  @GetMapping("/job-apps")
  public String jobApplicationsList(Model model) {
    // User user = new User();
    List<JobApplicationDto> jobApplications = jobApplicationService.getAllJobApplications();
    // String username = "Careless"; // FIXME: Update to use session username
    // if (username != null) {
    //   user = userService.loadUserByUsername(username);
    //   model.addAttribute("user", user);
    // }
    model.addAttribute("job_applications", jobApplications);
    return "/job-applications";
  }

  @GetMapping("/job-app/{job-app-id}")
  public String jobApplicationDetails(@PathVariable("job-app-id") long jobAppId, Model model) {
    // User user = new User();
    JobApplicationDto jobAppDto = jobApplicationService.findJobApplicationById(jobAppId);
    // String username = "Careless"; // FIXME; Update to use session username
    //
    // if (username != null) {
    //   user = userService.findByUsername(username);
    //   model.addAttribute("user", user);
    // }
    // model.addAttribute("user", user);
    model.addAttribute("JobApplication", jobAppDto);
    return "job-app-details";
  }

  @GetMapping("/job-app/new")
  public String jobApplicationCreate(Model model) {
    JobApplication jobApplication = new JobApplication();
    model.addAttribute("jobApplication", jobApplication);
    return "job-app-create";
  }

  @PostMapping("/job-app/new")
  public String JobApplicationCreate(@Valid @ModelAttribute("jobApplication") JobApplicationDto JobAppDto,
      Model model) {

    return "redirect:/job-apps";
  }

  @GetMapping("/job-app/{job-app-id}/edit")
  public String jobApplicationUpdate(@PathVariable("job-app-id") Long jobAppId, Model model) {

    return "job-app-create";
  }

  @PostMapping("/job-app/{job-app-id}/edit")
  public String JobApplicationUpdate(@PathVariable("job-app-id") Long jobAppId,
      @Valid @ModelAttribute("jobApplication") JobApplicationDto jobAppDto,
      BindingResult result, Model model) {

    return "redirect:/job-apps";
  }

  @GetMapping("/job-app/{job-app-id}/delete")
  public String jobApplicationDelete(@PathVariable("job-app-id") long jobAppId) {

    return "job-app-delete";
  }



}
