package com.project.pubgcommu.web.dto.team;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TeamSaveRequestDto {
    private String name;
    private List<TeamPlayerRequestDto> players;
    private Long killBet;

    @Builder
    public TeamSaveRequestDto(String name, List<TeamPlayerRequestDto> players, Long killBet){
        this.name = name;
        this.players = players;
        this.killBet = killBet;
    }
}
