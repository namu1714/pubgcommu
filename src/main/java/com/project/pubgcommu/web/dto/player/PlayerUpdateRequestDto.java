package com.project.pubgcommu.web.dto.player;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlayerUpdateRequestDto {
    private Long bj;
    private String nickname;

    @Builder
    PlayerUpdateRequestDto(Long id, Long bj, String nickname){
        this.bj = bj;
        this.nickname = nickname;
    }
}
