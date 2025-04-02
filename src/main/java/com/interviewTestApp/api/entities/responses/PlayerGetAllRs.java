package com.interviewTestApp.api.entities.responses;

import com.interviewTestApp.api.entities.baseEntities.PlayerItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerGetAllRs {
    private List<PlayerItem> players;
}
