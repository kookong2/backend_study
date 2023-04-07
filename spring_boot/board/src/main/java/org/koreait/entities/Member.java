package org.koreait.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.koreait.commons.constants.Role;

@Data @Builder
@Entity
@Table(indexes={
        @Index(name="idx_member_usernm", columnList = "userNm"),
        @Index(name="idx_regdt_desc", columnList = "regDt DESC")
})
@NoArgsConstructor @AllArgsConstructor
public class Member extends BaseEntity {
    @Id @GeneratedValue
    private Long userNo; // 회원번호
    @Column(length=45, nullable=false, unique = true)
    private String userId; // 아이디
    @Column(length=65, nullable=false)
    private String userPw; // 비밀번호
    @Column(length=45, nullable=false)
    private String userNm; // 회원명
    private String email; // 이메일
    @Column(length=11)
    private String mobile; // 휴대전화번호

    @Enumerated(EnumType.STRING)
    @Column(length=30)
    private Role role = Role.USER; // 기본값은 일반 사용자
}
