package com.project.pubgcommu.web.dto.game;

import com.project.pubgcommu.domain.killbet.GameLog;
import lombok.Getter;

@Getter
public class JoinedGameLogDto {
    private Long id;
    private Long member;
    private Integer kill;
    private Integer death;

    public JoinedGameLogDto(GameLog log){
        this.id = log.getId();
        this.member = log.getMember().getId();
        this.kill = log.getKill();
        this.death = log.getDeath();
    }
}
