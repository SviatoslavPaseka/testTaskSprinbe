package com.interviewTestApp.api.entities.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerUpdateRq {
    private Integer age;
    private String gender;
    private String password;
    private String login;
    private String role;
    private String screenName;
}
