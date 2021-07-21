package com.project.pubgcommu.web.dto.teamgamelog;

import com.project.pubgcommu.domain.killbet.TeamGameLog;
import lombok.Getter;

@Getter
public class TeamGameLogResponseDto {
    private Long id;
    private Long game;
    private Long team;
    private Integer chicken;
    private Integer stop;

    public TeamGameLogResponseDto(TeamGameLog teamGameLog){
        this.id = teamGameLog.getId();
        this.game = teamGameLog.getGame().getId();
        this.team = teamGameLog.getTeam().getId();
        this.chicken = teamGameLog.getChicken();
        this.stop = teamGameLog.getStop();
    }
}
