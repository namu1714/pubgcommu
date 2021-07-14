package com.project.pubgcommu.web.dto.killbet;

import com.project.pubgcommu.domain.killbet.KillBet;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class KillBetSaveRequestDto {
    private int killgoal;
    private boolean isLive;

    @Builder
    public KillBetSaveRequestDto(int killgoal, boolean isLive){
        this.killgoal = killgoal;
        this.isLive = isLive;
    }

    public KillBet toEntity(){
        return KillBet.builder()
                .killgoal(killgoal)
                .isLive(isLive)
                .createdDate(LocalDateTime.now())
                .build();
    }
}
