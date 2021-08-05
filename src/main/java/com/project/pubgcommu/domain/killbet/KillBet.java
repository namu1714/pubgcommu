package com.project.pubgcommu.domain.killbet;

import com.project.pubgcommu.domain.killbet.team.Team;
import com.sun.istack.NotNull;
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
public class KillBet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "killBet", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Team> teams = new ArrayList<>();

    @OneToMany(mappedBy = "killBet", cascade = {CascadeType.REMOVE})
    private List<Game> games = new ArrayList<>();

    @Column(nullable = false)
    private Integer killgoal;

    @Column(nullable = false)
    private Integer mapCycle;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "live", nullable = false)
    private Boolean isLive;

    @Builder
    public KillBet(Integer killgoal, Integer mapCycle, LocalDateTime createdDate, Boolean isLive){
        this.killgoal = killgoal;
        this.mapCycle = mapCycle;
        this.createdDate = createdDate;
        this.isLive = isLive;
    }

    public void updateLive(Boolean isLive){
        this.isLive = isLive;
    }

    public void update(Integer killgoal){
        this.killgoal  = killgoal;
    }
}
