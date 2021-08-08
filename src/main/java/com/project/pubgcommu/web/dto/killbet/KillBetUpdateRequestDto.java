package com.project.pubgcommu.web.dto.killbet;

import com.project.pubgcommu.domain.killbet.KillBet;
import com.project.pubgcommu.domain.killbet.team.Team;
import com.project.pubgcommu.web.dto.team.TeamUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class KillBetUpdateRequestDto {
    private Long id;
    private int killgoal;
    private int mapCycle;
    private List<TeamUpdateRequestDto> teams;

    @Builder
    public KillBetUpdateRequestDto(Long id, int killgoal, int mapCycle, List<TeamUpdateRequestDto> teams){
        this.id = id;
        this.mapCycle = mapCycle;
        this.killgoal = killgoal;
        this.teams = teams;
    }
}
