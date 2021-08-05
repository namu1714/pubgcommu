package com.project.pubgcommu.web.dto.gamelog;

import com.project.pubgcommu.domain.killbet.GameLog;
import lombok.Getter;

@Getter
public class GameLogResponseDto {
    private Long id;
    private Long game;
    private Long team;
    private Long member;
    private Integer kill;
    private Integer death;

    public GameLogResponseDto(GameLog gameLog){
        this.id = gameLog.getId();
        this.game = gameLog.getGame().getId();
        this.team = gameLog.getTeam().getId();
        this.member = gameLog.getPlayer().getId();
        this.kill = gameLog.getKill();
        this.death = gameLog.getDeath();
    }
}
