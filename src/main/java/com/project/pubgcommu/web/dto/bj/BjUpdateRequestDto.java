package com.project.pubgcommu.web.dto.bj;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BjUpdateRequestDto {
    private String gamenick;

    @Builder
    public BjUpdateRequestDto(String gamenick){
        this.gamenick = gamenick;
    }
}
