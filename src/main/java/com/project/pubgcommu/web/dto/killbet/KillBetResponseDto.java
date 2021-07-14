package com.project.pubgcommu.web.dto.killbet;

import com.project.pubgcommu.domain.killbet.KillBet;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class KillBetResponseDto {
    private Long id;
    private int killgoal;
    private boolean isLive;
    private LocalDateTime createdDate;


    public KillBetResponseDto(KillBet killBet){
        this.id = killBet.getId();
        this.killgoal = killBet.getKillgoal();
        this.isLive = killBet.getIsLive();
        this.createdDate = killBet.getCreatedDate();
    }
}
