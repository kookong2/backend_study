package org.koreait.controllers.boards;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardData {
    @NotBlank
    private String bId;
    @NotBlank
    private String poster;
    @NotBlank
    private String subject;
    @NotBlank
    private String content;
}
