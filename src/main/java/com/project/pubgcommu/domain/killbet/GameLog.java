package com.project.pubgcommu.domain.killbet;

import com.project.pubgcommu.domain.bj.Bj;
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

    @Column(nullable = false)
    private Integer kill = 0;

    @Column(nullable = false)
    private Integer death = 0;

    @Column(nullable = false)
    private Integer chicken = 0;

    @Column(nullable = false)
    private Integer stop = 0;

    @Builder
    public GameLog(Game game, Bj bj, Integer kill, Integer death, Integer chicken, Integer stop){
        this.game = game;
        this.bj = bj;
        this.kill = kill;
        this.death = death;
        this.chicken = chicken;
        this.stop = stop;
    }
}
