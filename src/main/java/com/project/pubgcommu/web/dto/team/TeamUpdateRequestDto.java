package com.project.pubgcommu.web.dto.team;

import com.project.pubgcommu.web.dto.player.PlayerUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TeamUpdateRequestDto {
    private Long id;
    private String name;
    private List<PlayerUpdateRequestDto> players;

    @Builder
    public TeamUpdateRequestDto(Long id, String name, List<PlayerUpdateRequestDto> players){
        this.id = id;
        this.name = name;
        this.players = players;
    }
}
