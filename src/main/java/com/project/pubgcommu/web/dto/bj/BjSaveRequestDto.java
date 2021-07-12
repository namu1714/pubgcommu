package com.project.pubgcommu.web.dto.bj;

import com.project.pubgcommu.domain.bj.Bj;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BjSaveRequestDto {
    private String name;
    private String gamenick;

    @Builder
    public BjSaveRequestDto(String name, String gamenick){
        this.name = name;
        this.gamenick = gamenick;
    }

    public Bj toEntity(){
        return Bj.builder()
                .name(name)
                .gamenick(gamenick)
                .build();
    }
}
