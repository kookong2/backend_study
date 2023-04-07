package org.koreait.exams;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.Address;
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
public class JPAExam06Test {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardDataRepository boardDataRepository;

    @BeforeEach
    public void insertDatas() {
        Member member = Member.builder()
                .userId("user01")
                .userPw("123456")
                .userNm("사용자01")
                .email("user01@test.org")
                .mobile("01000000000")
                .build();

        member = memberRepository.save(member);

        List<BoardData> datas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardData data = BoardData.builder()
                    .subject("제목" + i)
                    .content("내용" + i)
                    .member(member)
                    .build();
            datas.add(data);
        }

        boardDataRepository.saveAllAndFlush(datas);
    }

    @Test
    @DisplayName("@ManyToOne 테스트!")
    public void exam01() {
        BoardData data = boardDataRepository.findById(1L).orElse(null);
        Member member = data.getMember();

        System.out.println(data);
        System.out.println(member);
    }

    @Test
    @DisplayName("@OneToMany 테스트")
    public void exam02() {
        Member member = memberRepository.findById(1L).orElse(null);
        System.out.println(member);
        List<BoardData> datas = member.getBoardDatas();
        System.out.println(datas);
    }

    @Test
    @DisplayName("@OneToOne 테스트!")
    public void exam03() {
        Member member = memberRepository.findById(1L).orElse(null);
        Address address = member.getAddress();
        System.out.println(address);
    }

    @Test
    @DisplayName("지연로딩 테스트")
    @Transactional
    public void exam04() {
        BoardData data = boardDataRepository.findById(1L).orElse(null);
        Member member = data.getMember();
        String userId = member.getUserId();
        System.out.println(userId);
    }
}
