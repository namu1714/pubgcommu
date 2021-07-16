package com.project.pubgcommu.domain.killbet.team;

import com.project.pubgcommu.domain.killbet.KillBet;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Member> logs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "killbet_id", nullable = false)
    private KillBet killBet;

    private String name;

    @Builder
    public Team(String name, KillBet killBet){
        this.name = name;
        this.killBet = killBet;
    }

    public void update(String name){
        this.name = name;
    }

}
