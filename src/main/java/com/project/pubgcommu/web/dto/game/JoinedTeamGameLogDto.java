package com.project.pubgcommu.web.dto.game;

import com.project.pubgcommu.domain.killbet.TeamGameLog;
import lombok.Getter;

@Getter
public class JoinedTeamGameLogDto {
    private Long id;
    private Long team;
    private Integer chicken;
    private Integer stop;

    public JoinedTeamGameLogDto(TeamGameLog teamGameLog){
        this.id = teamGameLog.getId();
        this.team = teamGameLog.getTeam().getId();
        this.chicken = teamGameLog.getChicken();
        this.stop = teamGameLog.getStop();
    }
}
