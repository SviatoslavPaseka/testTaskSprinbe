package com.interviewTestApp.api.entities.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerUpdateRs {
    private Integer age;
    private String gender;
    private Long id;
    private String login;
    private String role;
    private String screenName;
}
