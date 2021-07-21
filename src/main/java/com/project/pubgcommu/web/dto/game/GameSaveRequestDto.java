package com.project.pubgcommu.web.dto.game;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameSaveRequestDto {
    private Long killBet;
    private String map;

    @Builder
    public GameSaveRequestDto(Long killBet, String map){
        this.killBet = killBet;
        this.map = map;
    }
}
