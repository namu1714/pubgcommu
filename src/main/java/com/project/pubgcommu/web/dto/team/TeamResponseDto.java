package com.project.pubgcommu.web.dto.team;

import com.project.pubgcommu.domain.killbet.team.Team;
import com.project.pubgcommu.web.dto.player.PlayerResponseDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TeamResponseDto {
    private Long id;
    private String name;
    private Long killBet;
    private List<PlayerResponseDto> players;

    public TeamResponseDto(Team team){
        this.id = team.getId();
        this.name = team.getName();
        this.killBet = team.getKillBet().getId();
        this.players = team.getPlayers()
                .stream().map(player -> new PlayerResponseDto(player))
                .collect(Collectors.toList());
    }
}
