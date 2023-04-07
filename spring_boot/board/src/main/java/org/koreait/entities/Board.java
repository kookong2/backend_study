package org.koreait.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.koreait.commons.constants.AccessLevel;

@Entity
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Table(indexes = {
        @Index(name = "idx_regdt_desc", columnList = "regDt DESC")
})
public class Board extends BaseEntity{
    @Id
    @Column(length = 30)
    private String bId;
    @Column(nullable = false, length = 60)
    private String boardNm;
    @Lob
    private String category;
    @Column(name = "is_Use")
    private boolean use;

    // 접근 권한
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private AccessLevel accessLevel = AccessLevel.ALL;

    private int noOfRows;   // 1페이지에 노출될 게시글 수
    private boolean comment;
    @Column(length = 30)
    private String attachFileType;  //파일 첨부(image, file)
    private boolean editor;

}
