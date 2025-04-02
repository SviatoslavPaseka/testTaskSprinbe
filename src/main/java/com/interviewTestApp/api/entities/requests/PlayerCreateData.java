package com.interviewTestApp.api.entities.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class PlayerCreateData {
    private Integer age;
    private String gender;
    private String password; //not required
    private String login;
    private String role;
    private String screenName;
}
