package com.project.pubgcommu.web.dto.team;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TeamSaveRequestDto {
    private String name;
    private List<TeamMemberRequestDto> members;
    private Long killBet;

    @Builder
    public TeamSaveRequestDto(String name, List<TeamMemberRequestDto> members, Long killBet){
        this.name = name;
        this.members = members;
        this.killBet = killBet;
    }
}
