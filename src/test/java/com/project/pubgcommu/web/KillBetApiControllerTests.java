package com.project.pubgcommu.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.bj.BjRepository;
import com.project.pubgcommu.domain.killbet.KillBet;
import com.project.pubgcommu.domain.killbet.KillBetRepository;
import com.project.pubgcommu.web.dto.bj.BjSaveRequestDto;
import com.project.pubgcommu.web.dto.killbet.KillBetSaveRequestDto;
import com.project.pubgcommu.web.dto.killbet.KillBetUpdateRequestDto;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:data/testQuery.sql"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KillBetApiControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Autowired
    private KillBetRepository repository;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void saveKillBet() throws Exception {
        //given
        int killgoal = 90;

        KillBetSaveRequestDto requestDto = KillBetSaveRequestDto.builder()
                .killgoal(killgoal)
                .isLive(true)
                .build();

        String url = "http://localhost:" + port + "/api/killbet";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<KillBet> all = repository.findAll();
        assertThat(all.get(0).getKillgoal()).isEqualTo(killgoal);
        assertThat(all.get(0).getIsLive()).isEqualTo(true);
    }

    @Test
    public void updateKillBet() throws Exception{
        Long id = 1L;
        int expectedKillgoal = 100;

        String url = "http://localhost:" + port + "/api/killbet/" + id;

        KillBetUpdateRequestDto requestDto = KillBetUpdateRequestDto.builder()
                .killgoal(expectedKillgoal)
                .build();

        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        List<KillBet> all = repository.findAll();
        assertThat(all.get(0).getKillgoal()).isEqualTo(expectedKillgoal);
    }

    @Test
    public void deleteKillBet() throws Exception{
        Long id = 2L;
        String url = "http://localhost:" + port + "/api/killbet/" + id;

        mvc.perform(delete(url))
                .andExpect(status().isOk());
    }
}
