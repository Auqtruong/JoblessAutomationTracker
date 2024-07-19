package com.unemployed.joblessautomationtracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.unemployed.joblessautomationtracker.user.User;
import com.unemployed.joblessautomationtracker.user.UserService;

import jakarta.validation.Valid;

@Controller
class OpenController {
  UserService userService;

  public OpenController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  public String index() {
    return "redirect:/home";
  }

  @GetMapping("/home")
  public String homePath() {
    return "/home";
  }

  @GetMapping("/login")
  public String loginPath() {
    return "/login";
  }

  @GetMapping("/register")
  public String getRegisterForm(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "/register";
  }

  @PostMapping("/register/save")
  public String register(@Valid @ModelAttribute("user") User user,
      BindingResult result, Model model) {
    User existingUserEmail = userService.findByEmail(user.getEmail());
    if (existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
      return "redirect:/register?fail";
    }
    User existingUserUsername = userService.findByUsername(user.getUsername());
    if (existingUserUsername != null && existingUserUsername.getUsername() != null
        && !existingUserUsername.getUsername().isEmpty()) {
      return "redirect:/register?fail";
    }
    if (result.hasErrors()) {
      model.addAttribute("user", user);
      return "register";
    }
    userService.save(user);
    return "redirect:/dashboard/job-apps?success";
  }

}
