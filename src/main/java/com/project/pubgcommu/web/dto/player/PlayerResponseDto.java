package com.project.pubgcommu.web.dto.player;

import com.project.pubgcommu.domain.killbet.team.Player;
import lombok.Getter;

@Getter
public class PlayerResponseDto {
    private Long id;
    private Long bj;
    private Long team;
    private String nickname;

    public PlayerResponseDto(Player player){
        this.id = player.getId();
        this.team = player.getTeam().getId();
        this.nickname = player.getNickname();
        if(player.getBj() != null)
            this.bj = player.getBj().getId();
    }
}
