package com.project.pubgcommu.service.bj;

import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.bj.BjRepository;
import com.project.pubgcommu.web.dto.bj.BjResponseDto;
import com.project.pubgcommu.web.dto.bj.BjSaveRequestDto;
import com.project.pubgcommu.web.dto.bj.BjUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BjService {
    private final BjRepository bjRepository;

    public Long save(BjSaveRequestDto requestDto){
        return bjRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, BjUpdateRequestDto requestDto){
        Bj bj = bjRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("등록된 BJ가 없습니다."));
        bj.update(requestDto.getNickname());

        return id;
    }

    @Transactional
    public void delete(Long id){
        Bj bj = bjRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("등록된 BJ가 없습니다."));

        bjRepository.delete(bj);
    }

    public List<BjResponseDto> findAll(){
        return bjRepository.findAll().stream()
                .map(BjResponseDto::new)
                .collect(Collectors.toList());
    }

    public BjResponseDto findById(Long id){
        Bj entity = bjRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("등록된 BJ가 없습니다."));

        return new BjResponseDto(entity);
    }

    public List<BjResponseDto> findByNick(String nickname){
        return bjRepository.findBjNick(nickname).stream()
                .map(BjResponseDto::new)
                .collect(Collectors.toList());
    }
}
