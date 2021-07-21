package com.project.pubgcommu.web.dto.killbet;

import com.project.pubgcommu.domain.killbet.KillBet;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class KillBetSaveRequestDto {
    private Integer killgoal;
    private Integer live;

    @Builder
    public KillBetSaveRequestDto(Integer killgoal, Integer live){
        this.killgoal = killgoal;
        this.live = live;
    }

    public KillBet toEntity(){
        return KillBet.builder()
                .killgoal(killgoal)
                .isLive(this.live > 0 ? true : false)
                .createdDate(LocalDateTime.now())
                .build();
    }
}
