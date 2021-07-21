package com.project.pubgcommu.web.dto.game;

import com.project.pubgcommu.domain.killbet.GameLog;
import lombok.Getter;

@Getter
public class JoinedGameLogDto {
    private Long id;
    private Long memberId;

    public JoinedGameLogDto(GameLog log){
        this.id = log.getId();
        this.memberId = log.getMember().getId();
    }
}
