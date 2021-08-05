package com.project.pubgcommu.web.dto.killbet;

import com.project.pubgcommu.web.dto.team.TeamPlayerRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class KillBetTeamRequestDto {
    private String name;
    private List<TeamPlayerRequestDto> players;

    @Builder
    public KillBetTeamRequestDto(String name, List<TeamPlayerRequestDto> players){
        this.name = name;
        this.players = players;
    }
}
