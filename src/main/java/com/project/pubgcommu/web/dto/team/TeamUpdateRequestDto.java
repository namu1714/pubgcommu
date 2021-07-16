package com.project.pubgcommu.web.dto.team;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamUpdateRequestDto {
    private Long id;
    private String name;

    @Builder
    public TeamUpdateRequestDto(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
