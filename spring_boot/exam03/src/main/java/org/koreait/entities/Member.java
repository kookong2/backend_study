package org.koreait.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.koreait.models.member.MemberRole;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userNo;
    @Column(length=45, nullable=false, unique=true)
    private String userId;

    @Column(length=65, nullable=false)
    private String userPw;

    @Column(length=45, nullable=false)
    private String userNm;

    private String email;

    @Column(length=11)
    private String mobile;

    @Enumerated(EnumType.STRING)
    @Column(length=40, nullable=false)
    private MemberRole role = MemberRole.USER;

}
