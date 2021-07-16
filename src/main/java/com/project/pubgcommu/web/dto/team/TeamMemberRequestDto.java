package com.project.pubgcommu.web.dto.team;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamMemberRequestDto {
    private Long bj;
    private String nickname;

    @Builder
    public TeamMemberRequestDto(Long bj, String nickname){
        this.bj = bj;
        this.nickname = nickname;
    }
}
