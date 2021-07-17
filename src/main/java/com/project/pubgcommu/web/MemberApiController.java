package com.project.pubgcommu.web;

import com.project.pubgcommu.service.killbet.MemberService;
import com.project.pubgcommu.web.dto.member.MemberResponseDto;
import com.project.pubgcommu.web.dto.member.MemberSaveRequestDto;
import com.project.pubgcommu.web.dto.member.MemberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/api/member")
    public Long save(@RequestBody MemberSaveRequestDto requestDto){
        return memberService.save(requestDto);
    }

    @PutMapping("/api/member/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemberUpdateRequestDto requestDto){
        return memberService.update(requestDto);
    }

    @GetMapping("/api/member/{id}")
    public MemberResponseDto findById(@PathVariable Long id){
        return memberService.findById(id);
    }
}
