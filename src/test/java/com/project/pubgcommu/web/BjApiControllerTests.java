package com.project.pubgcommu.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.pubgcommu.domain.bj.Bj;
import com.project.pubgcommu.domain.bj.BjRepository;
import com.project.pubgcommu.web.dto.bj.BjSaveRequestDto;
import com.project.pubgcommu.web.dto.bj.BjUpdateRequestDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BjApiControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BjRepository bjRepository;

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
    public void SaveBj() throws Exception {
        //given
        String name = "무이bj";
        String gamenick = "무이닉넴";
        BjSaveRequestDto requestDto = BjSaveRequestDto.builder()
                .name(name)
                .gamenick(gamenick)
                .build();

        String url = "http://localhost:" + port + "/api/bj";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Bj> all = bjRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getGamenick()).isEqualTo(gamenick);
    }

    @Test
    public void UpdateBj() throws Exception {
        //given
        Bj savedBj = bjRepository.save(Bj.builder()
            .name("무이bj")
            .gamenick("무이닉넴").build());

        Long updateId = savedBj.getId();
        String expectedGamenick = "닉넴수정";

        BjUpdateRequestDto requestDto = BjUpdateRequestDto.builder()
                .gamenick(expectedGamenick)
                .build();

        String url = "http://localhost:" + port + "/api/bj/" + updateId;

        //when
        mvc.perform(patch(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Bj> all = bjRepository.findAll();
        assertThat(all.get(0).getGamenick()).isEqualTo(expectedGamenick);
    }
}
