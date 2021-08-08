package com.project.pubgcommu.domain.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String role;

    @ManyToOne
    @JoinColumn(name = "member", nullable = false)
    private Member member;

    @Builder
    public Auth(String role, Member member){
        this.role = role;
        this.member = member;
    }
}
