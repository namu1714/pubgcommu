package com.project.pubgcommu.service.killbet;

import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.bj.BjRepository;
import com.project.pubgcommu.domain.killbet.KillBet;
import com.project.pubgcommu.domain.killbet.KillBetRepository;
import com.project.pubgcommu.domain.killbet.team.Player;
import com.project.pubgcommu.domain.killbet.team.PlayerRepository;
import com.project.pubgcommu.domain.killbet.team.Team;
import com.project.pubgcommu.domain.killbet.team.TeamRepository;
import com.project.pubgcommu.web.dto.killbet.KillBetResponseDto;
import com.project.pubgcommu.web.dto.killbet.KillBetSaveRequestDto;
import com.project.pubgcommu.web.dto.killbet.KillBetTeamRequestDto;
import com.project.pubgcommu.web.dto.killbet.KillBetUpdateRequestDto;
import com.project.pubgcommu.web.dto.team.TeamPlayerRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class KillBetService {
    private final KillBetRepository killBetRepository;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final BjRepository bjRepository;

    @Transactional
    public Long save(KillBetSaveRequestDto requestDto){
        //save killbet
        KillBet killbet = killBetRepository.save(KillBet.builder()
                .killgoal(requestDto.getKillgoal())
                .mapCycle(requestDto.getMapCycle())
                .isLive(requestDto.getLive() > 0 ? true : false)
                .createdDate(LocalDateTime.now())
                .build());

        //save team
        for(KillBetTeamRequestDto teamRequestDto : requestDto.getTeams()){
            Team team = teamRepository.save(Team.builder()
                    .killBet(killbet)
                    .name(teamRequestDto.getName())
                    .build());

            for(TeamPlayerRequestDto playerRequestDto : teamRequestDto.getPlayers()){
                Long bjId = playerRequestDto.getBj();
                Bj bj = null;
                if(bjId != null && bjId > 0) {
                    bj = bjRepository.getById(bjId);
                }

                Player player = playerRepository.save(Player.builder()
                        .team(team)
                        .bj(bj)
                        .nickname(playerRequestDto.getNickname())
                        .build());
            }
        }
        return killbet.getId();
    }

    @Transactional
    public Long updateLive(Long id, boolean isLive){
        KillBet killBet = killBetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 킬내기는 존재하지 않습니다."));
        killBet.updateLive(isLive);

        return id;
    }

    @Transactional
    public Long update(Long id, KillBetUpdateRequestDto requestDto){
        KillBet killBet = killBetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 킬내기는 존재하지 않습니다."));
        killBet.update(requestDto.getKillgoal(), requestDto.getMapCycle());

        return id;
    }

    @Transactional
    public void delete(Long id){
        KillBet killBet = killBetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 킬내기는 존재하지 않습니다."));

        killBetRepository.delete(killBet);
    }

    public List<KillBetResponseDto> findAll(){
        return killBetRepository.findAll().stream()
                .map(KillBetResponseDto::new)
                .collect(Collectors.toList());
    }

    public KillBetResponseDto findById(Long id){
        KillBet entity = killBetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 킬내기는 존재하지 않습니다."));

        return new KillBetResponseDto(entity);
    }


}
