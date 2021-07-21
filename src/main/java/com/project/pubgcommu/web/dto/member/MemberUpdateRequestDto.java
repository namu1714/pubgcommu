package com.project.pubgcommu.web.dto.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {
    private Long bj;
    private String nickname;

    @Builder
    MemberUpdateRequestDto(Long id, Long bj, String nickname){
        this.bj = bj;
        this.nickname = nickname;
    }
}
