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
    @JoinColumn(name = "bj_id", nullable = false)
    private Bj bj;

    @ManyToOne
    @JoinColumn(name = "killbet_id", nullable = false)
    private KillBet killbet;

    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private Team team;

    @Builder
    public KillBetLog(Bj bj, KillBet killbet, Team team){
        this.bj = bj;
        this.killbet = killbet;
        this.team = team;
    }
}
