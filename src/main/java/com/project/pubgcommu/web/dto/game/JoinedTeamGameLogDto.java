package com.project.pubgcommu.web.dto.game;

import com.project.pubgcommu.domain.killbet.TeamGameLog;
import lombok.Getter;

@Getter
public class JoinedTeamGameLogDto {
    private Long id;
    private Long teamId;

    public JoinedTeamGameLogDto(TeamGameLog teamGameLog){
        this.id = teamGameLog.getId();
        this.teamId = teamGameLog.getTeam().getId();
    }
}
