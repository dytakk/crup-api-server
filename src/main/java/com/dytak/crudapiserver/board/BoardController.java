package com.dytak.crudapiserver.board;

import com.dytak.crudapiserver.common.DTO;
import com.dytak.crudapiserver.common.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    BoardController(BoardService boardService){
        this.boardService=boardService;
    }

    @RequestMapping("/board")
    public ResponseEntity<?> getBoardList(Pageable pageable){
        return ResponseEntity.ok().body(boardService.findBoardList(pageable));
    }
    @RequestMapping("/board/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable Long id){
        return ResponseEntity.ok().body(boardService.findBoardDetailById(id));
    }

}
