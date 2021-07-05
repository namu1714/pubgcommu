package com.project.pubgcommu.domain.bj;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BjRepositorytest {

    @Autowired
    BjRepository bjRepository;

    @After
    public void cleanup(){
        bjRepository.deleteAll();
    }

    @Test
    public void registerBj(){
        String bjName = "무이";
        String gamenick = "무이닉네임";

        bjRepository.save(Bj.builder().name(bjName).gamenick(gamenick).build());

        List<Bj> bjList = bjRepository.findAll();

        Bj bj = bjList.get(0);
        assertThat(bj.getName()).isEqualTo(bjName);
        assertThat(bj.getGamenick()).isEqualTo(gamenick);
    }
}
