package com.dytak.crudapiserver.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    BoardController(BoardService boardService){
        this.boardService=boardService;
    }

    @PostMapping("/board")
    public ResponseEntity<?> saveBoard(@RequestBody BoardSaveDTO boardSaveDTO){
        return ResponseEntity.ok().body(boardService.saveBoard(boardSaveDTO));
    }

    @PutMapping("/board")
    public ResponseEntity<?> modifyBoard(@RequestBody BoardSaveDTO boardSaveDTO){
        return ResponseEntity.ok().body(boardService.modifyBoard(boardSaveDTO));
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id){
        return ResponseEntity.ok().body(boardService.deleteBoard(id));
    }

    @RequestMapping("/board")
    public ResponseEntity<?> findBoard(Pageable pageable){
        return ResponseEntity.ok().body(boardService.findBoardList(pageable));
    }
    @RequestMapping("/board/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable Long id){
        return ResponseEntity.ok().body(boardService.findBoardDetailById(id));
    }

}
