package org.koreait.models.board;

import lombok.RequiredArgsConstructor;
import org.koreait.commons.constants.AccessLevel;
import org.koreait.controllers.admins.BoardConfig;
import org.koreait.entities.Board;
import org.koreait.repositories.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardSaveService {
    private BoardRepository repository;

    public void save(BoardConfig board){
        Board entity = null;
        String mode = board.getMode();
        String bId = board.getBId();            // 게시판 아이디
        if(mode != null && mode.equals("update")){  // 수정
            entity = repository.findById(bId).orElseGet(()-> Board.builder().bId(bId).build());
        }else { // 추가
            entity = new Board();
            entity.setBId(bId);
        }

        entity.setBoardNm(board.getBoardName());
        entity.setCategory(board.getCategory());
        entity.setUse(board.isUse());
        entity.setAccessLevel(AccessLevel.valueOf(board.getAccessLevel()));
        entity.setNoOfRows(board.getNoOfRows());
        entity.setComment(board.isComment());
        entity.setEditor(board.isEditor());
        // 파일 첨부
        List<String> attachFileTypes = board.getAttachFileType();
        String attachFileType = attachFileTypes == null ? null : attachFileTypes
                                                                    .stream()
                                                                    .collect(Collectors.joining("||"));
        entity.setAttachFileType(attachFileType);   // image || file

        repository.save(entity);    // 추가 & 수정
    }
}
