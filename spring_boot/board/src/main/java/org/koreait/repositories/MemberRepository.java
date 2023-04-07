package org.koreait.repositories;

import com.querydsl.core.BooleanBuilder;
import org.koreait.entities.Member;
import org.koreait.entities.QMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor {
    Member findByUserId(String userId);

    /**
     * 등록된 회원 아이디 여부 체크
     * @param userId
     * @return
     */
    default boolean isExists(String userId) {
        QMember member = QMember.member;
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(member.userId.eq(userId));
        long cnt = this.count(builder);

        return cnt > 0;
    }
}
