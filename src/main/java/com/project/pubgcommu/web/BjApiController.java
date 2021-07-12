package com.project.pubgcommu.web;

import com.project.pubgcommu.service.bj.BjService;
import com.project.pubgcommu.web.dto.bj.BjResponseDto;
import com.project.pubgcommu.web.dto.bj.BjSaveRequestDto;
import com.project.pubgcommu.web.dto.bj.BjUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BjApiController {
    private final BjService bjService;

    @PostMapping("/api/bj")
    public Long save(@RequestBody BjSaveRequestDto requestDto) {
        return bjService.save(requestDto);
    }

    @PatchMapping("/api/bj/{id}")
    public Long update(@PathVariable Long id, @RequestBody BjUpdateRequestDto requestDto){
        return bjService.update(id, requestDto);
    }

    @DeleteMapping("/api/bj/{id}")
    public Long delete(@PathVariable Long id){
        bjService.delete(id);
        return id;
    }

    @GetMapping("/api/bj/{id}")
    public BjResponseDto findById (@PathVariable Long id){
        return bjService.findById(id);
    }

    @GetMapping("/api/bj")
    public List<BjResponseDto> findByNick (String name){
        return bjService.findByNick(name);
    }

    @GetMapping("/api/bjs")
    public List<BjResponseDto> findAll(){
        return bjService.findAll();
    }
}
