package com.project.pubgcommu.web.dto.killbet;

import com.project.pubgcommu.web.dto.team.TeamSaveRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class KillBetSaveRequestDto {
    private Integer killgoal;
    private Integer live;
    private Integer mapCycle;
    private List<TeamSaveRequestDto> teams;

    @Builder
    public KillBetSaveRequestDto(Integer killgoal, Integer live, Integer mapCycle, List<TeamSaveRequestDto> teams){
        this.killgoal = killgoal;
        this.live = live;
        this.mapCycle = mapCycle;
        this.teams = teams;
    }
}
