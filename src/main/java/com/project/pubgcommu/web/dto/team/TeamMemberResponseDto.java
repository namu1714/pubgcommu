package com.project.pubgcommu.web.dto.team;

import com.project.pubgcommu.domain.killbet.team.Member;
import lombok.Getter;

@Getter
public class TeamMemberResponseDto {
    private Long id;
    private String nickname;

    public TeamMemberResponseDto(Member log){
        this.id = log.getId();
        this.nickname = log.getNickname();
    }
}
