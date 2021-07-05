package com.project.pubgcommu.domain.killbet.team;

import com.project.pubgcommu.domain.killbet.KillBet;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "killbet_id", nullable = false)
    private KillBet killBet;

    private String name;
}
