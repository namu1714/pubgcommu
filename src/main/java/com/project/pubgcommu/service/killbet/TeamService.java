package com.project.pubgcommu.service.killbet;

import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.bj.BjRepository;
import com.project.pubgcommu.domain.killbet.KillBet;
import com.project.pubgcommu.domain.killbet.team.Player;
import com.project.pubgcommu.domain.killbet.KillBetRepository;
import com.project.pubgcommu.domain.killbet.team.Team;
import com.project.pubgcommu.domain.killbet.team.TeamRepository;
import com.project.pubgcommu.web.dto.team.TeamPlayerRequestDto;
import com.project.pubgcommu.web.dto.team.TeamResponseDto;
import com.project.pubgcommu.web.dto.team.TeamSaveRequestDto;
import com.project.pubgcommu.web.dto.team.TeamUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final KillBetRepository killBetRepository;
    private final BjRepository bjRepository;

    @Transactional
    public Long save(TeamSaveRequestDto requestDto){
        //킬내기 존재여부 확인
        KillBet killBet = killBetRepository.findById(requestDto.getKillBet())
                .orElseThrow(() -> new IllegalArgumentException("해당 킬내기는 존재하지 않습니다."));

        //팀 객체 생성
        Team team = Team.builder()
                .name(requestDto.getName())
                .killBet(killBet)
                .build();

        //팀 멤버 추가
        for (TeamPlayerRequestDto playerDto:requestDto.getPlayers()) {
            Long bjId = playerDto.getBj();
            Bj bj = null;

            if(bjId != null && bjId > 0) {
                bj = bjRepository.getById(bjId);
            }

            Player player = Player.builder()
                    .bj(bj)
                    .nickname(playerDto.getNickname())
                    .team(team).build();

            team.getPlayers().add(player);
        }

        return teamRepository.save(team).getId();
    }

    @Transactional
    public Long update(Long id, TeamUpdateRequestDto requestDto){
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 팀입니다."));
        team.update(requestDto.getName());
        return id;
    }

    public TeamResponseDto findById(Long id){
        Team entity = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 팀입니다."));

        return new TeamResponseDto(entity);
    }
}
