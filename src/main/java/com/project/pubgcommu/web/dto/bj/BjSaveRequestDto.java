package com.project.pubgcommu.web.dto.bj;

import com.project.pubgcommu.domain.bj.Bj;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BjSaveRequestDto {
    private String name;
    private String nickname;

    @Builder
    public BjSaveRequestDto(String name, String nickname){
        this.name = name;
        this.nickname = nickname;
    }

    public Bj toEntity(){
        return Bj.builder()
                .name(name)
                .nickname(nickname)
                .build();
    }
}
