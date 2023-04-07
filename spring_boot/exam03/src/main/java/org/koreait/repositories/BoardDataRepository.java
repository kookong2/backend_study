package org.koreait.repositories;

import org.koreait.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor {
    List<BoardData> findBySubjectContaining(String key); // LIKE '%key%'

    List<BoardData> findByContentContainingOrderByRegDtDesc(String key);

    List<BoardData> findByRegDtBetween(LocalDateTime s1, LocalDateTime s2);

    @Query("SELECT b FROM BoardData b WHERE b.content LIKE %:key% ORDER BY b.regDt DESC")
    List<BoardData> findByContent(@Param("key") String key);

    @Query("SELECT b FROM BoardData b JOIN FETCH b.member")
    List<BoardData> findBySubject();
}
