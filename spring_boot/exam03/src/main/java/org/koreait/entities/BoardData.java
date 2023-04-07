package org.koreait.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter @Setter @Builder
@ToString(exclude="member")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BoardData extends BaseMemberEntity {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(length=150, nullable=false)
    private String subject;

    @Lob
    @Column(nullable=false)
    private String content;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userNo")
    private Member member;

}
