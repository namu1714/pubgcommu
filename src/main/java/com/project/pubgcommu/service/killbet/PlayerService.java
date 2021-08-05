package com.project.pubgcommu.service.killbet;

import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.bj.BjRepository;
import com.project.pubgcommu.domain.killbet.team.Player;
import com.project.pubgcommu.domain.killbet.team.PlayerRepository;
import com.project.pubgcommu.domain.killbet.team.Team;
import com.project.pubgcommu.domain.killbet.team.TeamRepository;
import com.project.pubgcommu.web.dto.player.PlayerResponseDto;
import com.project.pubgcommu.web.dto.player.PlayerSaveRequestDto;
import com.project.pubgcommu.web.dto.player.PlayerUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PlayerService {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final BjRepository bjRepository;

    @Transactional
    public Long save(PlayerSaveRequestDto requestDto){
        Bj bj = null;
        Team team = teamRepository.findById(requestDto.getTeam())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 팀입니다."));

        Long bjId = requestDto.getBj();
        if(bjId != null && bjId > 0)
            bj = bjRepository.getById(bjId);

        return playerRepository.save(Player.builder()
                .bj(bj)
                .team(team)
                .nickname(requestDto.getNickname())
                .build()).getId();
    }

    @Transactional
    public Long update(Long id, PlayerUpdateRequestDto requestDto){
        Bj bj = null;
        Long bjId = requestDto.getBj();
        if(bjId != null && bjId > 0)
            bj = bjRepository.getById(bjId);

        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 킬내기 멤버입니다."));

        player.update(bj, requestDto.getNickname());
        return player.getId();
    }

    public PlayerResponseDto findById(Long id){
        Player entity = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 킬내기 멤버입니다."));

        return new PlayerResponseDto(entity);
    }
}
