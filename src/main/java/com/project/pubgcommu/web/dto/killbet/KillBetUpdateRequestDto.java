package com.project.pubgcommu.web.dto.killbet;

import com.project.pubgcommu.domain.killbet.KillBet;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KillBetUpdateRequestDto {
    private int killgoal;

    @Builder
    public KillBetUpdateRequestDto(int killgoal){
        this.killgoal = killgoal;
    }

    public KillBet toEntity(){
        return KillBet.builder()
                .killgoal(killgoal)
                .build();
    }
}
