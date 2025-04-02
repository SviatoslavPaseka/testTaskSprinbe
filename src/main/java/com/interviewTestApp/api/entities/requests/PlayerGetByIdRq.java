package com.interviewTestApp.api.entities.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerGetByIdRq {
    @JsonProperty("playerId")
    private Integer playerId;
}

