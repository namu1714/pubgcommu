package com.project.pubgcommu.domain.killbet.team;

import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.killbet.KillBet;
import com.project.pubgcommu.domain.killbet.team.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {

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
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Column(nullable = false)
    private String nickname;

    @Builder
    public Member(Bj bj, KillBet killBet, Team team, String nickname){
        this.bj = bj;
        this.nickname = nickname;
        this.killBet = killBet;
        this.team = team;
    }
}
