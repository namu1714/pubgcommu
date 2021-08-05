package com.project.pubgcommu.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.pubgcommu.domain.killbet.team.Team;
import com.project.pubgcommu.domain.killbet.team.TeamRepository;
import com.project.pubgcommu.web.dto.team.TeamPlayerRequestDto;
import com.project.pubgcommu.web.dto.team.TeamSaveRequestDto;
import com.project.pubgcommu.web.dto.team.TeamUpdateRequestDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:data/testQuery.sql"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamApiControllerTests {

    @Autowired
    private TeamRepository teamRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    @Transactional
    public void saveTeam() throws Exception{
        String teamName = "team1";
        String memberNick1 = "member1";

        TeamPlayerRequestDto member1 = TeamPlayerRequestDto.builder().nickname(memberNick1).build();
        List<TeamPlayerRequestDto> players = Arrays.asList(new TeamPlayerRequestDto[]{member1});

        TeamSaveRequestDto requestDto = TeamSaveRequestDto.builder()
                .name(teamName)
                .killBet(1L)
                .players(players)
                .build();

        String url = "http://localhost:" + port + "/api/team";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        List<Team> all = teamRepository.findAll();
        assertThat(all.get(1).getName()).isEqualTo(teamName);
        assertThat(all.get(1).getPlayers().get(0).getNickname()).isEqualTo(memberNick1);
    }

    @Test
    public void updateTeam() throws Exception{
        Long id = 1L;
        String teamName = "newteam";

        TeamUpdateRequestDto requestDto = TeamUpdateRequestDto.builder().name(teamName).build();
        String url = "http://localhost:" + port + "/api/team/" + id;

        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        Team team = teamRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
        assertThat(team.getName()).isEqualTo(teamName);
    }
}
