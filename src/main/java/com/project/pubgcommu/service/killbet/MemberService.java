package com.project.pubgcommu.service.killbet;

import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.bj.BjRepository;
import com.project.pubgcommu.domain.killbet.team.Member;
import com.project.pubgcommu.domain.killbet.team.MemberRepository;
import com.project.pubgcommu.domain.killbet.team.Team;
import com.project.pubgcommu.domain.killbet.team.TeamRepository;
import com.project.pubgcommu.web.dto.member.MemberResponseDto;
import com.project.pubgcommu.web.dto.member.MemberSaveRequestDto;
import com.project.pubgcommu.web.dto.member.MemberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final BjRepository bjRepository;

    @Transactional
    public Long save(MemberSaveRequestDto requestDto){
        Bj bj = null;
        Team team = teamRepository.findById(requestDto.getTeam())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 팀입니다."));

        Long bjId = requestDto.getBj();
        if(bjId != null && bjId > 0)
            bj = bjRepository.getById(bjId);

        return memberRepository.save(Member.builder()
                .bj(bj)
                .team(team)
                .nickname(requestDto.getNickname())
                .build()).getId();
    }

    @Transactional
    public Long update(MemberUpdateRequestDto requestDto){
        Bj bj = null;
        Long bjId = requestDto.getBj();
        if(bjId != null && bjId > 0)
            bj = bjRepository.getById(bjId);

        Member member = memberRepository.findById(requestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 킬내기 멤버입니다."));

        member.update(bj, requestDto.getNickname());
        return member.getId();
    }

    public MemberResponseDto findById(Long id){
        Member entity = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 킬내기 멤버입니다."));

        return new MemberResponseDto(entity);
    }
}
