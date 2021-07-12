package com.project.pubgcommu.service.killbet;

import com.project.pubgcommu.domain.killbet.KillBetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KillBetService {
    private final KillBetRepository killBetRepository;

}
