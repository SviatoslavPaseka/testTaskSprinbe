package com.interviewTestApp.api.entities.baseEntities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PlayerItem {
    private Integer age;
    private String gender;
    private Long id;
    private String screenName;
}
