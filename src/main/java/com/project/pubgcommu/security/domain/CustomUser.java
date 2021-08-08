package com.project.pubgcommu.security.domain;

import com.project.pubgcommu.domain.auth.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUser extends User {
    private static final long serialVersionUID = 1L;

    private Member member;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUser(Member member){
        super(member.getMemberId(), member.getPassword(), member.getAuths()
                .stream().map(auth -> new SimpleGrantedAuthority(auth.getRole()))
                .collect(Collectors.toList()));
    }
}
