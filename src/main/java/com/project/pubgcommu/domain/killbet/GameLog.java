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
public class GameLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "bj_id", nullable = false)
    private Bj bj;

    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private Team team;

    @Column(nullable = false)
    private Integer kill = 0;

    @Column(nullable = false)
    private Integer death = 0;

    @Builder
    public GameLog(Game game, Bj bj, Integer kill, Integer death){
        this.game = game;
        this.bj = bj;
        this.team = team;
        this.kill = kill;
        this.death = death;
    }
}
