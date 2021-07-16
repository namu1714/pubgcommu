package com.project.pubgcommu.domain.bj;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BjRepositorytest {

    @Autowired
    BjRepository bjRepository;

    @Test
    public void registerBj(){
        //given
        String bjName = "무이";
        String gamenick = "무이닉네임";

        bjRepository.save(Bj.builder().name(bjName).nickname(gamenick).build());

        //when
        List<Bj> bjList = bjRepository.findAll();

        //then
        Bj bj = bjList.get(0);
        assertThat(bj.getName()).isEqualTo(bjName);
        assertThat(bj.getNickname()).isEqualTo(gamenick);
    }

    @Test
    public void findByGamenick(){
        //given
        String gamenick = "무이닉네임";

        //when
        List<Bj> bjList = bjRepository.findBjNick(gamenick);

        //then
        assertThat(bjList.get(0).getNickname()).isEqualTo(gamenick);
    }

    @Test
    public void deleteBj(){
        Optional<Bj> bj = bjRepository.findById(1L);

        Assert.assertTrue(bj.isPresent());

        bj.ifPresent(selectBj->{
            bjRepository.delete(selectBj);
        });
        Optional<Bj> deleteBj = bjRepository.findById(1L);
        Assert.assertFalse(deleteBj.isPresent());
    }
}
