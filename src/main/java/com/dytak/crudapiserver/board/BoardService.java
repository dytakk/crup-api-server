package com.dytak.crudapiserver.board;

import com.dytak.crudapiserver.entity.Board;
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

    //TODO: Sorting, 검색기능 필요
    public Page<Board> findBoardList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }




    public Optional<Board> findBoardDetailById(Long id){
      return boardRepository.findById(id);
    }
}
