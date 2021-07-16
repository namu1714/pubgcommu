package com.project.pubgcommu.domain.bj;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BjRepository extends JpaRepository<Bj, Long> {

    @Query("SELECT b FROM Bj b where b.nickname = ?1")
    List<Bj> findBjNick(String nickname);

}
