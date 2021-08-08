package com.project.pubgcommu.web.dto.player;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class PlayerSaveRequestDto {
    private Long bj;
    private String nickname;

    @Setter
    private Long team;

    @Builder
    PlayerSaveRequestDto(Long bj, Long team, String nickname){
        this.bj = bj;
        this.team = team;
        this.nickname = nickname;
    }
}
