package com.unemployed.joblessautomationtracker.jobapplication;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;

@Data
@Builder
public class JobApplicationDto {
    private Long id;
    @NotEmpty(message = "Position cannot be empty")
    private String positionTitle;

    @NotEmpty(message = "Company cannot be empty")
    private String companyTitle;

    @NotEmpty(message = "Submission Date cannot be empty")
    private LocalDateTime submittedOn;
}


