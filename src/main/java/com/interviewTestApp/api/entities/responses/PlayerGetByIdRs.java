package com.interviewTestApp.api.entities.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerGetByIdRs {
    private Integer age;
    private String gender;
    private Long id;
    private String login;
    private String password;
    private String role;
    private String screenName;
}
