package org.koreait.exams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.BoardData;
import org.koreait.repositories.BoardDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import static org.springframework.data.domain.Sort.Order.*;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class JPAExam02Test {
    @Autowired
    private BoardDataRepository repository;

    @Test
    @DisplayName("연습1")
    public void exam01() {
        BoardData boardData = BoardData.builder()
                                .subject("제목")
                                .content("내용")
                                .build();

        BoardData data = repository.saveAndFlush(boardData);
        data.setSubject("제목(수정)");
        data.setContent("내용(수정)");
        repository.save(data);

        BoardData data2 = repository.findById(data.getId()).orElse(null);
        System.out.println(data2);

    }

    @BeforeEach
    @DisplayName("기본 데이터 추가!")
    public void insertDatas() {
        List<BoardData> boardDatas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardData data = BoardData.builder()
                    .subject("제목" + i)
                    .content("내용" + i)
                    .build();
            boardDatas.add(data);
        }

        repository.saveAllAndFlush(boardDatas);
    }

    @Test
    @DisplayName("연습2!")
    public void exam02() {
       // List<BoardData> boardDatas = repository.findAll();
       // List<BoardData> boardDatas = repository.findAll(Sort.by(desc("id"), asc("regDt")));
        //Pageable pageable = PageRequest.of(0, 3, Sort.by(desc("id")));
        //Page<BoardData> page = repository.findAll(pageable);
        //List<BoardData> boardDatas = page.getContent();
        List<BoardData> boardDatas = repository.findBySubjectContaining("제목");
        boardDatas.stream().forEach(System.out::println);
    }
}
