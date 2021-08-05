package com.project.pubgcommu.web.dto.killbet;

import com.project.pubgcommu.domain.killbet.KillBet;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KillBetUpdateRequestDto {
    private int killgoal;
    private int mapCycle;

    @Builder
    public KillBetUpdateRequestDto(int killgoal, int mapCycle){
        this.mapCycle = mapCycle;
        this.killgoal = killgoal;
    }
}
