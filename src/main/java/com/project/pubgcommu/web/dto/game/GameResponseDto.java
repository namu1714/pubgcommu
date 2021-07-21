package com.project.pubgcommu.web.dto.game;

import com.project.pubgcommu.domain.killbet.Game;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GameResponseDto {
    private Long id;
    private Long killBet;
    private String map;
    private List<JoinedGameLogDto> gameLogs;
    private List<JoinedTeamGameLogDto> teamGameLogs;

    public GameResponseDto(Game game){
        this.id = game.getId();
        this.killBet = game.getKillBet().getId();
        this.map = game.getMap();
        this.gameLogs = game.getLogs()
                .stream().map(log -> new JoinedGameLogDto(log))
                .collect(Collectors.toList());
        this.teamGameLogs = game.getTeamLogs()
                .stream().map(teamLog -> new JoinedTeamGameLogDto(teamLog))
                .collect(Collectors.toList());
    }
}
