package com.snp.feedservice.service.jpa;

import com.mysql.cj.exceptions.ExceptionFactory;
import com.snp.feedservice.jpa.entity.Feed;
import com.snp.feedservice.jpa.repository.FeedRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class FeedRepositoryTest {

    @Autowired
    private FeedRepository feedRepository;
    
    @Test
    @DisplayName("전체 피드 리스트")
    void findAll() {

        //given

        //when
        List<Feed> feeds = feedRepository.findAll();

        //then
        assertNotNull(feeds);

    }
    
    @Test
    @DisplayName("피드 저장")
    void save() {

        //given
        Feed feed = Feed.builder()
                .memberIdx(5)
                .title("피드저장소스테스트01")
                .content("피드저장소스테스트")
                .registDate(LocalDateTime.now())
                .build();

        //when
        feedRepository.save(feed);

        //then
        Assertions.assertDoesNotThrow(ExceptionFactory::new);

    }

}
