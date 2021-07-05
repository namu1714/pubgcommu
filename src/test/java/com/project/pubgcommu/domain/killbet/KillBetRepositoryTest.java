package com.project.pubgcommu.domain.killbet;

import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.bj.BjRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KillBetRepositoryTest {

    @Autowired
    BjRepository bjRepository;

    @Autowired
    KillBetRepository killBetRepository;

    @Autowired
    KillBetLogRepository killBetLogRepository;

    public void cleanup(){
        killBetLogRepository.deleteAll();
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
        String gamenick = "무이닉네임";

        Bj bj = Bj.builder().name(bjName).gamenick(gamenick).build();
        bjRepository.save(bj);

        KillBet killBet = killBetRepository.findById(1L)
                .orElseThrow(()-> new IllegalArgumentException("킬내기 게시글이 존재하지 않습니다."));

        killBetLogRepository.save(KillBetLog.builder()
                .bj(bj)
                .killbet(killBet)
                .totalKill(0)
                .totalDeath(0)
                .team("A")
                .build());

        List<KillBetLog> killBetLogList = killBetLogRepository.findAll();
        KillBetLog killBetLog = killBetLogList.get(0);

        assertThat(killBetLog.getBj().getName()).isEqualTo(bjName);
        assertThat(killBetLog.getBj().getGamenick()).isEqualTo(gamenick);
    }

    @Test
    public void updateKillBetLog(){

    }

    @Test
    public void deleteKillBet(){

    }

}
