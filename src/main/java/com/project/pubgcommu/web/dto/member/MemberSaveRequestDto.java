package com.project.pubgcommu.web.dto.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private Long bj;
    private Long team;
    private String nickname;

    @Builder
    MemberSaveRequestDto(Long bj, Long team, String nickname){
        this.bj = bj;
        this.team = team;
        this.nickname = nickname;
    }
}
