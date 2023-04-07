package org.koreait.controllers.admins;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardConfig {
    private String mode;    // mode가 update면 수정
    @NotBlank(message="게시판 아이디를 입력하세요")
    private String bId;

    @NotBlank(message="게시판 이름을 입력하세요.")
    private String boardName;


    private String category;

    private boolean use;

    private String accessLevel;

    private int noOfRows; //1 페이지에 노출될 게시글 수

    private boolean comment;

    private List<String> attachFileType; // 파일첨부(image,File)

    private boolean editor;

}
