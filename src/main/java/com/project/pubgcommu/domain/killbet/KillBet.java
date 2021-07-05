package com.project.pubgcommu.domain.killbet;

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

    @OneToMany(mappedBy = "killbet", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<KillBetLog> logs = new ArrayList<>();

    @Column(nullable = false)
    private Integer killgoal;

    private String teamNameA;
    private String teamNameB;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "live", nullable = false)
    private Boolean isLive;

    @Builder
    public KillBet(Integer killgoal, LocalDateTime createdDate, Boolean isLive){
        this.killgoal = killgoal;
        this.createdDate = createdDate;
        this.isLive = isLive;
    }
}
