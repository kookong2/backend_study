package org.koreait.exams;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.BoardData;
import org.koreait.entities.Member;
import org.koreait.repositories.BoardDataRepository;
import org.koreait.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
@Transactional
public class JPAExam99Test {
    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private BoardDataRepository boardDataRepo;

    public void insertData() {
        Member member = Member.builder()
                .userId("user01")
                .userPw("123456")
                .userNm("사용자01")
                .email("user01@test.org")
                .mobile("01000000000")
                .build();

        memberRepo.save(member);

        List<BoardData> datas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardData data = BoardData.builder()
                    .subject("제목" + i)
                    .content("내용" + i)
                    .member(member)
                    .build();
            datas.add(data);

        }

        boardDataRepo.saveAll(datas);

        Member m = memberRepo.findById(1L).orElse(null);
        System.out.println(m);

        List<BoardData> bData = m.getBoardDatas();
        System.out.println(bData);

    }

    @Test
    @DisplayName("테스트1")
    public void exam01() {
        insertData();
    }
}
