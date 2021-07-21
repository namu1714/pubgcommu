package com.project.pubgcommu.web;

import com.project.pubgcommu.service.killbet.GameService;
import com.project.pubgcommu.web.dto.game.GameResponseDto;
import com.project.pubgcommu.web.dto.game.GameSaveRequestDto;
import com.project.pubgcommu.web.dto.game.GameUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GameApiController {
    private final GameService gameService;

    @GetMapping("/api/game/{id}")
    public GameResponseDto findById(@PathVariable Long id){
        return gameService.findById(id);
    }

    @PostMapping("/api/game")
    public Long save(@RequestBody GameSaveRequestDto requestDto){
        return gameService.save(requestDto);
    }

    @PutMapping("/api/game/{id}")
    public Long update(@PathVariable Long id, @RequestBody GameUpdateRequestDto requestDto){
        return gameService.update(id, requestDto);
    }

    @DeleteMapping("/api/game/id")
    public Long delete(@PathVariable Long id){
        gameService.delete(id);
        return id;
    }
}
