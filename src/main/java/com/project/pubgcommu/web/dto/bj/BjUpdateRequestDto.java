package com.project.pubgcommu.web.dto.bj;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BjUpdateRequestDto {
    private String nickname;

    @Builder
    public BjUpdateRequestDto(String nickname){
        this.nickname = nickname;
    }
}
