package com.project.pubgcommu.web.dto.killbet;

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
    private List<KillBetTeamRequestDto> teams;

    @Builder
    public KillBetSaveRequestDto(Integer killgoal, Integer live, Integer mapCycle, List<KillBetTeamRequestDto> teams){
        this.killgoal = killgoal;
        this.live = live;
        this.mapCycle = mapCycle;
        this.teams = teams;
    }
    /*
    public KillBet toEntity(){
        return KillBet.builder()
                .killgoal(killgoal)
                .mapCycle(mapCycle)
                .isLive(this.live > 0 ? true : false)
                .createdDate(LocalDateTime.now())
                .build();
    }
    */
}
