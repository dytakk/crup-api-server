package com.dytak.crudapiserver.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import java.util.*;

@org.springframework.stereotype.Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    BoardService(BoardRepository boardRepository){
        this.boardRepository=boardRepository;
    }

    //TODO: Sorting, 검색기능, content는 Response항목에 불필요
    public Page<Board> findBoardList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public Optional<Board> findBoardDetailById(Long id){
        return boardRepository.findById(id);
    }
    public Long saveBoard(BoardDTO dto){
        boardRepository.save(dto.toEntity());
        return dto.getId();
    }

    public Long modifyBoard(BoardDTO dto){
        boardRepository.save(dto.toEntity());
        return dto.getId();
    }

    public Long deleteBoard(Long id){
        boardRepository.deleteById(id);
        return id;
    }
}
