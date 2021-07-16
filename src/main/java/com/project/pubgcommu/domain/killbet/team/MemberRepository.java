package com.project.pubgcommu.domain.killbet.team;

import com.project.pubgcommu.domain.killbet.team.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
