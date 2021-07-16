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

    private String nickname;

    @Builder
    public Bj(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public void update(String nickname){
        this.nickname = nickname;
    }
}
