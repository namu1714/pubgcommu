package com.project.pubgcommu.web;

import com.project.pubgcommu.service.killbet.PlayerService;
import com.project.pubgcommu.web.dto.player.PlayerResponseDto;
import com.project.pubgcommu.web.dto.player.PlayerSaveRequestDto;
import com.project.pubgcommu.web.dto.player.PlayerUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PlayerApiController {
    private final PlayerService playerService;

    @PostMapping("/api/member")
    public Long save(@RequestBody PlayerSaveRequestDto requestDto){
        return playerService.save(requestDto);
    }

    @PutMapping("/api/member/{id}")
    public Long update(@PathVariable Long id, @RequestBody PlayerUpdateRequestDto requestDto){
        return playerService.update(id, requestDto);
    }

    @GetMapping("/api/member/{id}")
    public PlayerResponseDto findById(@PathVariable Long id){
        return playerService.findById(id);
    }
}
