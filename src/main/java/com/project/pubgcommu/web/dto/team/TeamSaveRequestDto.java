package com.project.pubgcommu.web.dto.team;

import com.project.pubgcommu.web.dto.player.PlayerSaveRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TeamSaveRequestDto {
    private String name;
    private List<PlayerSaveRequestDto> players;
    private Long killBet;

    @Builder
    public TeamSaveRequestDto(String name, List<PlayerSaveRequestDto> players, Long killBet){
        this.name = name;
        this.players = players;
        this.killBet = killBet;
    }
}
