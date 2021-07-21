package com.project.pubgcommu.web;

import com.project.pubgcommu.service.killbet.TeamGameLogService;
import com.project.pubgcommu.web.dto.gamelog.GameLogResponseDto;
import com.project.pubgcommu.web.dto.teamgamelog.TeamGameLogResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TeamGameLogApiController {
    private final TeamGameLogService teamGameLogService;

    @GetMapping("/api/teamgamelog/{id}")
    public TeamGameLogResponseDto findById(@PathVariable Long id){
        return teamGameLogService.findById(id);
    }

    @PatchMapping("/api/teamgamelog/{id}/chicken/{add}")
    public Long updateChicken(@PathVariable Long id, @PathVariable Integer add){
        return teamGameLogService.updateChicken(id, add);
    }

    @PatchMapping("/api/teamgamelog/{id}/stop/{add}")
    public Long updateStop(@PathVariable Long id, @PathVariable Integer add){
        return teamGameLogService.updateStop(id, add);
    }
}
