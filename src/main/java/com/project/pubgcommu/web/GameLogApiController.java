package com.project.pubgcommu.web;

import com.project.pubgcommu.service.killbet.GameLogService;
import com.project.pubgcommu.web.dto.gamelog.GameLogResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class GameLogApiController {
    private final GameLogService gameLogService;

    @GetMapping("/api/gamelog/{id}")
    public GameLogResponseDto findById(@PathVariable Long id){
        return gameLogService.findById(id);
    }

    @PatchMapping("/api/gamelog/{id}/kill/{add}")
    public Long updateKill(@PathVariable Long id, @PathVariable Integer add){
        return gameLogService.updateKill(id, add);
    }

    @PatchMapping("/api/gamelog/{id}/death/{add}")
    public Long updateDeath(@PathVariable Long id, @PathVariable Integer add){
        return gameLogService.updateDeath(id, add);
    }
}
