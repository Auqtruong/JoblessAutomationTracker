package com.unemployed.joblessautomationtracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.unemployed.joblessautomationtracker.jobapplication.JobApplicationRepository;

@SpringBootApplication
public class JoblessautomationtrackerApplication {

	@Autowired //repo to save jobs into later
	private JobApplicationRepository jobApplicationRepository;

	public static void main(String[] args) {
		SpringApplication.run(JoblessautomationtrackerApplication.class, args);
	}

	@Bean//function to test jobApplications going into db
	public AppTester initializeJobs(){
		//add new test/example jobs instances
		
		//save jobs into repo created above
	}

}
