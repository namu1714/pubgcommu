package com.project.pubgcommu.web.dto.team;

import com.project.pubgcommu.domain.killbet.team.Player;
import lombok.Getter;

@Getter
public class TeamPlayerResponseDto {
    private Long id;
    private String nickname;

    public TeamPlayerResponseDto(Player log){
        this.id = log.getId();
        this.nickname = log.getNickname();
    }
}
