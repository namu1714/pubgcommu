package com.project.pubgcommu.web.dto.game;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameUpdateRequestDto {
    private String map;

    @Builder
    public GameUpdateRequestDto(String map){
        this.map = map;
    }
}
