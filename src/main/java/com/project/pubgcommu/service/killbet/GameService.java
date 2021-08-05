package com.project.pubgcommu.service.killbet;

import com.project.pubgcommu.domain.killbet.*;
import com.project.pubgcommu.domain.killbet.team.Player;
import com.project.pubgcommu.domain.killbet.team.Team;
import com.project.pubgcommu.web.dto.game.GameResponseDto;
import com.project.pubgcommu.web.dto.game.GameSaveRequestDto;
import com.project.pubgcommu.web.dto.game.GameUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;

    private final KillBetRepository killBetRepository;
    private final TeamGameLogRepository teamGameLogRepository;
    private final GameLogRepository gameLogRepository;

    @Transactional
    public Long save(GameSaveRequestDto requestDto){
        //킬내기 존재여부 확인
        KillBet killBet = killBetRepository.findById(requestDto.getKillBet())
                .orElseThrow(() -> new IllegalArgumentException("해당 킬내기는 존재하지 않습니다."));

        //save game
        Game game = gameRepository.save(Game.builder()
                .killBet(killBet)
                .map(requestDto.getMap())
                .createdDate(LocalDateTime.now()).build());

        //save teamgamelog, gamelog
        for(Team team : killBet.getTeams()){
            teamGameLogRepository.save(TeamGameLog.builder()
                    .team(team)
                    .game(game)
                    .chicken(0)
                    .stop(0).build());

            for (Player player : team.getPlayers()){
                gameLogRepository.save(GameLog.builder()
                        .team(team)
                        .game(game)
                        .player(player)
                        .death(0)
                        .kill(0).build());
            }
        }
        return game.getId();
    }

    @Transactional
    public Long update(Long id, GameUpdateRequestDto requestDto){
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게임입니다."));

        game.update(requestDto.getMap());
        return id;
    }

    @Transactional
    public void delete(Long id){
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게임입니다."));

        gameRepository.delete(game);
    }

    public GameResponseDto findById(Long id){
        Game entity = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게임입니다."));
        return new GameResponseDto(entity);
    }
}
