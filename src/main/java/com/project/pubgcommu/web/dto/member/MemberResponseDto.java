package com.project.pubgcommu.web.dto.member;

import com.project.pubgcommu.domain.killbet.team.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long id;
    private Long bj;
    private Long team;
    private String nickname;

    public MemberResponseDto(Member member){
        this.id = member.getId();
        this.team = member.getTeam().getId();
        this.nickname = member.getNickname();
        if(member.getBj() != null)
            this.bj = member.getBj().getId();
    }
}
