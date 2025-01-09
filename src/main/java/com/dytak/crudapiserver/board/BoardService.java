package com.dytak.crudapiserver.board;

import com.dytak.crudapiserver.comment.Comment;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;


import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    BoardService(BoardRepository boardRepository){
        this.boardRepository=boardRepository;
    }

    public Page<BoardListDTO> getBoardList(Pageable pageable){
        return BoardListDTO.of(boardRepository.findAll(pageable));
    }

    public BoardDetailDTO findBoardDetailById(Long id){
        Board board = boardRepository.findById(id).get();
        return BoardDetailDTO.of(board);
    }
    public Long saveBoard(BoardSaveDTO dto){
        boardRepository.save(dto.toEntity());
        return dto.getId();
    }

    public Long modifyBoard(BoardSaveDTO dto){
        boardRepository.save(dto.toEntity());
        return dto.getId();
    }

    public Long deleteBoard(Long id){
        boardRepository.deleteById(id);
        return id;
    }
}
