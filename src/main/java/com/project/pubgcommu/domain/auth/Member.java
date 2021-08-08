package com.project.pubgcommu.domain.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String password;

    private String nickname;

    private String email;

    @Column(nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "member", cascade = {CascadeType.REMOVE})
    private List<Auth> auths;

    @Builder
    public Member(String memberId, String password, String nickname, String email){
        this.memberId = memberId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
}
