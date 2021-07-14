package com.project.pubgcommu.service.killbet;

import com.project.pubgcommu.domain.killbet.KillBet;
import com.project.pubgcommu.domain.killbet.KillBetRepository;
import com.project.pubgcommu.web.dto.killbet.KillBetResponseDto;
import com.project.pubgcommu.web.dto.killbet.KillBetSaveRequestDto;
import com.project.pubgcommu.web.dto.killbet.KillBetUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class KillBetService {
    private final KillBetRepository killBetRepository;

    public Long save(KillBetSaveRequestDto requestDto){
        return killBetRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long updateLive(Long id, boolean isLive){
        KillBet killBet = killBetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 킬내기는 존재하지 않습니다."));
        killBet.updateLive(isLive);

        return id;
    }

    @Transactional
    public Long update(Long id, KillBetUpdateRequestDto requestDto){
        KillBet killBet = killBetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 킬내기는 존재하지 않습니다."));
        killBet.update(requestDto.getKillgoal());

        return id;
    }

    @Transactional
    public void delete(Long id){
        KillBet killBet = killBetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 킬내기는 존재하지 않습니다."));

        killBetRepository.delete(killBet);
    }

    public List<KillBetResponseDto> findAll(){
        return killBetRepository.findAll().stream()
                .map(KillBetResponseDto::new)
                .collect(Collectors.toList());
    }

    public KillBetResponseDto findById(Long id){
        KillBet entity = killBetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 킬내기는 존재하지 않습니다."));

        return new KillBetResponseDto(entity);
    }


}
