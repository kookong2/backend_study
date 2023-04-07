package org.koreait.exams;

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
public class JPAExam05Test {
    private Member member;

    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private BoardDataRepository repository;

    @BeforeEach
    public void createMember() {
        Address addr = Address.builder()
                .address("주소1")
                .addressSub("주소2")
                .zipCode("12345")
                .build();
        Member params = Member.builder()
                .userId("user01")
                .userPw("123456")
                .userNm("사용자01")
                .email("user01@test.org")
                .mobile("01000000000")
                .address(addr)
                .build();

        member = memberRepo.saveAndFlush(params);

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

        //List<BoardData> datas2 = member.getBoardDatas();
        //datas2.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("@ManyToOne 연습!")
    public void exam01() {
        BoardData data = BoardData.builder()
                .subject("제목1")
                .content("내용1")
                .member(member)
                .build();

        repository.save(data);

        data = repository.findById(1L).orElse(null);
        System.out.println(data);

        Member m = data.getMember();
        System.out.println(m);

    }

    @Test
    @DisplayName("@OneToMany 연습")
    public void exam02() {
        Member member = memberRepo.findById(1L).orElse(null);
        List<BoardData> datas = member.getBoardDatas();
       // datas.stream().forEach(System.out::println);
    }
}
