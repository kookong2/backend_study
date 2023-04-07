package org.koreait.commons.rests;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JSON 응답 항목
 *
 * @param <T>
 */
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class JSONResult<T> {
    private boolean success;
    private int status = HttpServletResponse.SC_OK;
    private String message;
    private T data;
}
