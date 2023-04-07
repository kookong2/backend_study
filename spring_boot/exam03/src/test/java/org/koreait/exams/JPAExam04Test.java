package org.koreait.exams;


import com.querydsl.core.BooleanBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.BoardData;
import org.koreait.entities.Member;
import org.koreait.entities.QBoardData;
import org.koreait.entities.QMember;
import org.koreait.repositories.BoardDataRepository;
import org.koreait.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class JPAExam04Test {

    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private BoardDataRepository repository;

    @BeforeEach
    public void insertDatas() {
        Member member = Member.builder()
                .userId("user01")
                .userPw("123456")
                .userNm("사용자01")
                .email("user01@test.org")
                .mobile("01000000000")
                .build();
        member = memberRepo.save(member);

        List<BoardData> datas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardData data = BoardData.builder()
                    .subject("제목" + i)
                    .content("내용" + i)
                    .member(member)
                    .build();

            datas.add(data);
        }

        repository.saveAllAndFlush(datas);
    }

    @Test
    @DisplayName("QueryDSL 연습1")
    public void exam01() {
        BooleanBuilder builder = new BooleanBuilder();
        // 쿼리에 들어갈 조건을 만들어주는 빌더
        // Predicate를 구현하고 있으며, 메서드 체인 방식으로 사용할 수 있음

        QBoardData boardData = QBoardData.boardData;
        builder.and(boardData.subject.contains("제목"))
                .and(boardData.content.contains("내용"));

        List<BoardData> datas = (List<BoardData>)repository.findAll(builder);
        datas.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("QueryDSL 연습 - JOIN")
    public void exam02() {
        QBoardData boardData = QBoardData.boardData;
        QMember member = boardData.member; //
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(member.userId.eq("user01"));

        List<BoardData> datas = (List<BoardData>)repository.findAll(builder);
        datas.stream().forEach(System.out::println);
    }
}
