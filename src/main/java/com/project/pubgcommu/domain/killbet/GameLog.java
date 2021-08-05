package com.project.pubgcommu.domain.killbet;

import com.project.pubgcommu.domain.killbet.team.Player;
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
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(nullable = false)
    private Integer kill;

    @Column(nullable = false)
    private Integer death;

    @Builder
    public GameLog(Game game, Team team, Player player, Integer kill, Integer death){
        this.game = game;
        this.team = team;
        this.player = player;
        this.kill = kill;
        this.death = death;
    }

    public void updateKill(int add){
        this.kill += add;
    }

    public void updateDeath(int add){
        this.death += add;
    }
}
