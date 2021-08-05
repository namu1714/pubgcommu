package com.project.pubgcommu.web.dto.killbet;

import com.project.pubgcommu.domain.killbet.KillBet;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class KillBetResponseDto {
    private Long id;
    private Integer killgoal;
    private Integer live;
    private Integer mapCycle;
    private LocalDateTime createdDate;
    private List<Long> teams;
    private List<Long> games;

    public KillBetResponseDto(KillBet killBet){
        this.id = killBet.getId();
        this.killgoal = killBet.getKillgoal();
        this.live = killBet.getIsLive() ? 1 : 0;
        this.createdDate = killBet.getCreatedDate();
        this.mapCycle = killBet.getMapCycle();
        this.teams = killBet.getTeams()
                .stream().map(team->team.getId())
                .collect(Collectors.toList());
        this.games = killBet.getGames()
                .stream().map(game->game.getId())
                .collect(Collectors.toList());
    }
}
