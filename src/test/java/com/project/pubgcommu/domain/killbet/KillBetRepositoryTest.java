package com.project.pubgcommu.domain.killbet;

import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.bj.BjRepository;
import com.project.pubgcommu.domain.killbet.team.Player;
import com.project.pubgcommu.domain.killbet.team.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KillBetRepositoryTest {

    @Autowired
    BjRepository bjRepository;

    @Autowired
    KillBetRepository killBetRepository;

    @Autowired
    PlayerRepository playerRepository;

    public void cleanup(){
        playerRepository.deleteAll();
        killBetRepository.deleteAll();
        bjRepository.deleteAll();
    }

    @Test
    public void registerKillBet(){
        int goal = 90;

        killBetRepository.save(KillBet.builder()
                .killgoal(goal)
                .isLive(true)
                .createdDate(LocalDateTime.now())
                .build());

        List<KillBet> killBetList = killBetRepository.findAll();

        KillBet killBet = killBetList.get(0);
        assertThat(killBet.getKillgoal()).isEqualTo(goal);
    }

    @Test
    public void registerKillBetLog(){
        String bjName = "무이";
        String nickname = "무이닉네임";

        Bj bj = Bj.builder().name(bjName).nickname(nickname).build();
        bjRepository.save(bj);

        KillBet killBet = killBetRepository.findById(1L)
                .orElseThrow(()-> new IllegalArgumentException("킬내기 게시글이 존재하지 않습니다."));

        playerRepository.save(Player.builder()
                .bj(bj)
                .nickname(nickname)
                .build());

        List<Player> playerList = playerRepository.findAll();
        Player player = playerList.get(0);

        assertThat(player.getBj().getName()).isEqualTo(bjName);
        assertThat(player.getBj().getNickname()).isEqualTo(nickname);
    }

    @Test
    public void updateKillBetLog(){

    }

    @Test
    public void deleteKillBet(){

    }

}
