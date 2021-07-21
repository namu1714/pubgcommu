package com.project.pubgcommu.service.killbet;

import com.project.pubgcommu.domain.killbet.GameLog;
import com.project.pubgcommu.domain.killbet.TeamGameLog;
import com.project.pubgcommu.domain.killbet.TeamGameLogRepository;
import com.project.pubgcommu.web.dto.teamgamelog.TeamGameLogResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TeamGameLogService {
    private final TeamGameLogRepository teamGameLogRepository;

    @Transactional
    public Long updateChicken(Long id, Integer add){
        if(add == null) return -1L;

        TeamGameLog teamGameLog = teamGameLogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 팀 게임로그입니다."));

        teamGameLog.updateChicken(add);
        return id;
    }

    @Transactional
    public Long updateStop(Long id, Integer add){
        if(add == null) return -1L;

        TeamGameLog teamGameLog = teamGameLogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 팀 게임로그입니다."));

        teamGameLog.updateStop(add);
        return id;
    }

    public TeamGameLogResponseDto findById(Long id){
        TeamGameLog entity = teamGameLogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게임로그입니다."));
        return new TeamGameLogResponseDto(entity);
    }
}
