package com.dytak.crudapiserver.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    BoardController(BoardService boardService){
        this.boardService=boardService;
    }

    @PostMapping
    public ResponseEntity<?> saveBoard(@RequestBody BoardSaveDTO dto){
        return ResponseEntity.ok().body(boardService.saveBoard(dto));
    }

    @PutMapping
    public ResponseEntity<?> modifyBoard(@RequestBody BoardSaveDTO dto){
        return ResponseEntity.ok().body(boardService.modifyBoard(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id){
        return ResponseEntity.ok().body(boardService.deleteBoard(id));
    }

    @GetMapping
    public ResponseEntity<?> getBoard(Pageable pageable){
        return ResponseEntity.ok().body(boardService.getBoardList(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable Long id){
        return ResponseEntity.ok().body(boardService.findBoardDetailById(id));
    }

}
