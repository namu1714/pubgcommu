package com.project.pubgcommu.domain.killbet;

import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.killbet.team.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class TeamGameLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private Team team;

    @Column(nullable = false)
    private Integer chicken;

    @Column(nullable = false)
    private Integer stop;

    public TeamGameLog(Game game, Team team, Integer chicken, Integer stop){
        this.game = game;
        this.team = team;
        this.chicken = chicken;
        this.stop = stop;
    }
}
