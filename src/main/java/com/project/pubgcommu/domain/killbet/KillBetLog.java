package com.project.pubgcommu.domain.killbet;

import com.project.pubgcommu.domain.bj.Bj;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class KillBetLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bj_id", nullable = false)
    private Bj bj;

    @ManyToOne
    @JoinColumn(name = "bet_id", nullable = false)
    private KillBet killbet;

    @Column(length = 1, nullable = false)
    private String team;

    @Column(name = "total_kill", nullable = false)
    private Integer totalKill;

    @Column(name = "total_death", nullable = false)
    private Integer totalDeath;

    @Builder
    public KillBetLog(Bj bj, KillBet killbet, String team, Integer totalKill, Integer totalDeath){
        this.bj = bj;
        this.killbet = killbet;
        this.team = team;
        this.totalKill = totalKill;
        this.totalDeath = totalDeath;
    }

    public void updateTotalKill(){
        this.totalKill += 1;
    }

    public void updateTotalDeath(){
        this.totalDeath += 1;
    }
}
