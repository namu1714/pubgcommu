package com.project.pubgcommu.web.dto.bj;

import com.project.pubgcommu.domain.bj.Bj;
import lombok.Getter;

@Getter
public class BjResponseDto {
    private Long id;
    private String name;
    private String gamenick;

    public BjResponseDto(Bj bj){
        this.id = bj.getId();
        this.name = bj.getName();
        this.gamenick = bj.getGamenick();
    }
}
