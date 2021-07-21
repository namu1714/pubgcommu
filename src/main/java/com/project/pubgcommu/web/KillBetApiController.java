package com.project.pubgcommu.web;

import com.project.pubgcommu.service.killbet.KillBetService;
import com.project.pubgcommu.web.dto.killbet.KillBetResponseDto;
import com.project.pubgcommu.web.dto.killbet.KillBetSaveRequestDto;
import com.project.pubgcommu.web.dto.killbet.KillBetUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class KillBetApiController {
    private final KillBetService killBetService;

    @PostMapping("/api/killbet")
    public Long save(@RequestBody KillBetSaveRequestDto requestDto) {
        return killBetService.save(requestDto);
    }

    @PutMapping("api/killbet/{id}")
    public Long update(@PathVariable Long id, @RequestBody KillBetUpdateRequestDto requestDto){
        return killBetService.update(id, requestDto);
    }

    @PatchMapping("api/killbet/{id}/live/{live}")
    public Long update(@PathVariable Long id, @PathVariable Integer live){
        boolean isLive = live > 0 ? true : false;

        return killBetService.updateLive(id, isLive);
    }

    @DeleteMapping("api/killbet/{id}")
    public Long delete(@PathVariable Long id){
        killBetService.delete(id);
        return id;
    }

    @GetMapping("/api/killbet/{id}")
    public KillBetResponseDto findById (@PathVariable Long id){
        return killBetService.findById(id);
    }

    @GetMapping("/api/killbets")
    public List<KillBetResponseDto> findAll (){
        return killBetService.findAll();
    }
}
