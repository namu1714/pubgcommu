package com.project.pubgcommu.security;

import com.project.pubgcommu.domain.auth.Member;
import com.project.pubgcommu.domain.auth.MemberRepository;
import com.project.pubgcommu.security.domain.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberId(username)
                .orElseThrow(() -> new UsernameNotFoundException("없는 유저입니다."));

        return member == null ? null : new CustomUser(member);
    }
}
