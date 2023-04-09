package org.koreait.models.board;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.koreait.controllers.admins.BoardConfig;
import org.koreait.controllers.admins.BoardNotFoundException;
import org.koreait.entities.Board;
import org.koreait.repositories.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardInfoService {

    @NonNull
    private BoardRepository repository;

    public BoardConfig get(String bId){
        if(bId == null || bId.isBlank()){
            throw new BoardNotFoundException();
        }
        Board board = repository.findById(bId).orElseThrow(BoardNotFoundException::new);

        String attachFileType = board.getAttachFileType();
        List<String> fileType = attachFileType == null ? null : Arrays.stream(attachFileType.split("||")).toList();


        BoardConfig config = BoardConfig.builder()
                .bId(board.getBId())
                .boardNm(board.getBoardNm())
                .use(board.isUse())
                .accessLevel(board.getAccessLevel().toString())
                .attachFileType(fileType)
                .comment(board.isComment())
                .category(board.getCategory())
                .noOfRows(board.getNoOfRows())
                .build();

        return config;
    }
}
