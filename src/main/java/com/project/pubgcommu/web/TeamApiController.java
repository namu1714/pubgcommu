package com.project.pubgcommu.web;

import com.project.pubgcommu.service.killbet.TeamService;
import com.project.pubgcommu.web.dto.team.TeamResponseDto;
import com.project.pubgcommu.web.dto.team.TeamSaveRequestDto;
import com.project.pubgcommu.web.dto.team.TeamUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TeamApiController {
    private final TeamService teamService;

    @PostMapping("/api/team")
    public Long save(@RequestBody TeamSaveRequestDto requestDto){
        return teamService.save(requestDto);
    }

    @GetMapping("/api/team/{id}")
    public TeamResponseDto findById(@PathVariable Long id){
        return teamService.findById(id);
    }

    @PutMapping("/api/team/{id}")
    public Long update(@PathVariable Long id, @RequestBody TeamUpdateRequestDto requestDto){
        return teamService.update(id, requestDto);
    }
}
