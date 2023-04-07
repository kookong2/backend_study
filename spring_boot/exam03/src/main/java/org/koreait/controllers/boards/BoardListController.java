package org.koreait.controllers.boards;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardListController {
    @GetMapping("/board/list")
    public ResponseEntity<Object> list() {
        return ResponseEntity.ok("목록");// 200, 목록
    }
}
