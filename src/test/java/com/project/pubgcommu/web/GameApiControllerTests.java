package com.project.pubgcommu.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.pubgcommu.domain.killbet.Game;
import com.project.pubgcommu.domain.killbet.GameRepository;
import com.project.pubgcommu.web.dto.game.GameSaveRequestDto;
import com.project.pubgcommu.web.dto.game.GameUpdateRequestDto;
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
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:data/testQuery.sql"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameApiControllerTests {

    @Autowired
    private GameRepository gameRepository;

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
    public void saveGame() throws Exception{
        String map = "사녹";

        GameSaveRequestDto requestDto = GameSaveRequestDto.builder()
                .killBet(1L)
                .map(map).build();

        String url = "http://localhost:" + port + "/api/game";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        List<Game> all = gameRepository.findAll();
        assertThat(all.get(0).getMap()).isEqualTo(map);
    }

    @Test
    public void updateGame() throws Exception{
        String map = "에란겔";

        GameUpdateRequestDto requestDto = GameUpdateRequestDto.builder()
                .map(map).build();

        String url = "http://localhost:" + port + "/api/game/1";

        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        List<Game> all = gameRepository.findAll();
        assertThat(all.get(0).getMap()).isEqualTo(map);
    }
}
