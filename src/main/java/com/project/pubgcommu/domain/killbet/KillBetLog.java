package com.project.pubgcommu.domain.killbet;

import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.killbet.team.Team;
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
    @JoinColumn(name = "bj_id")
    private Bj bj;

    @ManyToOne
    @JoinColumn(name = "killbet_id", nullable = false)
    private KillBet killBet;

    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private Team team;

    @Column(nullable = false)
    private String gamenick;

    @Builder
    public KillBetLog(Bj bj, KillBet killBet, Team team, String gamenick){
        this.bj = bj;
        this.gamenick = gamenick;
        this.killBet = killBet;
        this.team = team;
    }
}
