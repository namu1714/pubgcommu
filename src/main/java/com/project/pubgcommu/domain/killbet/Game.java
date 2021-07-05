package com.project.pubgcommu.domain.killbet;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bet_id")
    private KillBet killBet;

    @OneToMany(mappedBy = "game")
    private List<GameLog> logs = new ArrayList<>();

    @OneToMany(mappedBy = "game")
    private List<TeamGameLog> teamLogs = new ArrayList<>();

    @Column(nullable = false)
    private String map;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Builder
    public Game(KillBet killBet, String map, LocalDateTime createdDate){
        this.killBet = killBet;
        this.map = map;
        this.createdDate = createdDate;
    }
}
