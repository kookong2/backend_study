package org.koreait.exams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.BoardData;
import org.koreait.repositories.BoardDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class JPAExam03Test {

    @Autowired
    private BoardDataRepository repository;

    @BeforeEach
    public void insertDatas() {
        List<BoardData> datas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardData data = BoardData.builder()
                    .subject("제목" + i)
                    .content("내용" + i)
                    .build();

            datas.add(data);
        }

        repository.saveAllAndFlush(datas);
    }

    @Test
    @DisplayName("쿼리 메서드 연습!")
    public void exam01() {
        LocalDateTime date = LocalDateTime.now();
        LocalDateTime yesterday = date.minusDays(1);
        LocalDateTime tomorrow = date.plusDays(1);

        List<BoardData> datas1 = repository.findByRegDtBetween(yesterday, tomorrow);
        datas1.stream().forEach(System.out::println);

    }

    @Test
    @DisplayName("쿼리메서드 연습2")
    public void exam02() {
        List<BoardData> datas = repository.findByContentContainingOrderByRegDtDesc("내용");
        datas.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("@Query 애노테이션 연습")
    public void exam03() {
        List<BoardData> datas = repository.findByContent("내용");
        datas.stream().forEach(System.out::println);
    }
}
