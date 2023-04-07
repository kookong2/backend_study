package org.koreait.exams;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.BoardData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@Log
@Transactional
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class JPAExam01Test {

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("JPA 추가, 수정 연습!")
    public void exam01() {
        //EntityTransaction tx = em.getTransaction();
        //tx.begin();

        BoardData boardData = BoardData.builder()
                .subject("제목!")
                .content("내용!")
                .build();

        em.persist(boardData);
        long id = boardData.getId();
        BoardData data = em.find(BoardData.class, id);
        System.out.println("추가 : " + data);

        data.setSubject("제목(수정)");
        data.setContent("내용(수정)");

        data = em.find(BoardData.class, id);
        System.out.println("수정 : " + data);

        em.remove(data);

        em.flush();


        //tx.commit();
    }

    @BeforeEach
    public void insertData() {
        BoardData boardData = BoardData.builder()
                .subject("제목!")
                .content("내용!")
                .build();
        em.persist(boardData);
    }
    @Test
    @DisplayName("영속성 detach, merge 테스트")
    public void exam02() {

        BoardData boardData = em.find(BoardData.class, 1L);

        em.detach(boardData); // 영속성에서 분리 ->  변화 감지 X

        boardData.setSubject("제목(수정)");
        boardData.setContent("내용(수정)");

        em.merge(boardData); // 분리된 엔티티 -> 영속성 (변화 감지 O)

        //em.flush();

    }

    @Test
    @DisplayName("JPQL 연습!")
    public void exam03() {
        String sql = "SELECT b.subject, b.content FROM BoardData b WHERE b.subject LIKE :subject";
        Query q = (Query)em.createQuery(sql);
        q.setParameter("subject", "%제목%");
        List<Object[]> datas = q.getResultList();
        for (Object[] data : datas) {
            String subject = (String)data[0];
            String content = (String)data[1];
            System.out.printf("subject=%s,content=%s%n", subject, content);
        }
        //TypedQuery<BoardData> tq = em.createQuery(sql, BoardData.class);

        //tq.setParameter("subject", "%제목%");

        //List<BoardData> datas = tq.getResultList();
        /**
        System.out.println(datas);
        for (BoardData data : datas) {
            data.setSubject("제목(수정)");
        }
         */
        em.flush();
    }
}
