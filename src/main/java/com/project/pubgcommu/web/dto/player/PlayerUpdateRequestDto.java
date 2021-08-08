package com.project.pubgcommu.web.dto.player;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlayerUpdateRequestDto {
    private Long id;
    private Long bj;
    private String nickname;

    @Builder
    PlayerUpdateRequestDto(Long id, Long bj, String nickname){
        this.id = id;
        this.bj = bj;
        this.nickname = nickname;
    }
}
