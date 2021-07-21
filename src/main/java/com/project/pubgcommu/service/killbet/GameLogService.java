package com.project.pubgcommu.service.killbet;

import com.project.pubgcommu.domain.killbet.GameLog;
import com.project.pubgcommu.domain.killbet.GameLogRepository;
import com.project.pubgcommu.web.dto.gamelog.GameLogResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GameLogService {
    private final GameLogRepository gameLogRepository;

    @Transactional
    public Long updateKill(Long id, Integer add){
        if(add == null) return -1L;

        GameLog gameLog = gameLogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게임로그입니다."));

        gameLog.updateKill(add);
        return id;
    }

    @Transactional
    public Long updateDeath(Long id, Integer add){
        if(add == null) return -1L;

        GameLog gameLog = gameLogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게임로그입니다."));

        gameLog.updateDeath(add);
        return id;
    }

    public GameLogResponseDto findById(Long id){
        GameLog entity = gameLogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게임로그입니다."));
        return new GameLogResponseDto(entity);
    }
}
