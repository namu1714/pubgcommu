package com.project.pubgcommu.web.dto.player;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlayerSaveRequestDto {
    private Long bj;
    private Long team;
    private String nickname;

    @Builder
    PlayerSaveRequestDto(Long bj, Long team, String nickname){
        this.bj = bj;
        this.team = team;
        this.nickname = nickname;
    }
}
