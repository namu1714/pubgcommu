package com.project.pubgcommu.web.dto.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {
    private Long id;
    private Long bj;
    private String nickname;

    @Builder
    MemberUpdateRequestDto(Long id, Long bj, String nickname){
        this.id = id;
        this.bj = bj;
        this.nickname = nickname;
    }
}
