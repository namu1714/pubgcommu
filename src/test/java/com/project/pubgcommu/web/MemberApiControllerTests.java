package com.project.pubgcommu.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.pubgcommu.domain.killbet.team.Member;
import com.project.pubgcommu.domain.killbet.team.MemberRepository;
import com.project.pubgcommu.web.dto.member.MemberSaveRequestDto;
import com.project.pubgcommu.web.dto.member.MemberUpdateRequestDto;
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
public class MemberApiControllerTests {
    @Autowired
    private MemberRepository memberRepository;

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
    public void saveMember() throws Exception {
        String nickname = "닉네임쓰";
        Long bjId = 1L;

        MemberSaveRequestDto requestDto = MemberSaveRequestDto.builder()
                .bj(bjId)
                .nickname(nickname)
                .team(1L).build();

        String url = "http://localhost:" + port + "/api/member";

        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        List<Member> all = memberRepository.findAll();
        assertThat(all.get(0).getNickname()).isEqualTo(nickname);
    }

    @Test
    public void updateMember() throws Exception {
        String nickname = "닉네임수정";
        Long id = 1L;

        MemberUpdateRequestDto requestDto = MemberUpdateRequestDto.builder()
                .id(id)
                .nickname(nickname).build();

        String url = "http://localhost:" + port + "/api/member/" + id;

        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        List<Member> all = memberRepository.findAll();
        assertThat(all.get(0).getNickname()).isEqualTo(nickname);
    }
}
