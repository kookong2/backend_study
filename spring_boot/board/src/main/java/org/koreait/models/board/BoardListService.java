package org.koreait.models.board;

import lombok.RequiredArgsConstructor;
import org.koreait.controllers.admins.BoardConfig;
import org.koreait.entities.Board;
import org.koreait.repositories.BoardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.desc;

@Service
@RequiredArgsConstructor
public class BoardListService {
    private final BoardRepository repository;

    public List<BoardConfig> gets(){
        List<Board> boards = repository.findAll(Sort.by(desc("regDt")));
        List<BoardConfig> configs = boards.stream().map(this::toConfig).toList();

        return configs;
    }

    private BoardConfig toConfig(Board board){

        String attachFileType = board.getAttachFileType();
        List<String> fileTypes = attachFileType == null ? null : Arrays.stream(attachFileType.split("||")).toList();

        return BoardConfig.builder()
                .bId(board.getBId())
                .boardNm(board.getBoardNm())
                .category(board.getCategory())
                .use(board.isUse())
                .accessLevel(board.getAccessLevel().toString())
                .noOfRows(board.getNoOfRows())
                .attachFileType(fileTypes)
                .editor(board.isEditor())
                .build();
    }
}
