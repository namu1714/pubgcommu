package com.project.pubgcommu.domain.bj;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Bj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String gamenick;

    @Builder
    public Bj(String name, String gamenick) {
        this.name = name;
        this.gamenick = gamenick;
    }
}
