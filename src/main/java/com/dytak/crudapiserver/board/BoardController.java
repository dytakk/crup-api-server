package com.dytak.crudapiserver.board;

import com.dytak.crudapiserver.common.ResCodeMsg;
import com.dytak.crudapiserver.common.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

  private final BoardService boardService;

  @Autowired
  BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @PostMapping
  public ResponseEntity<?> saveBoard(@RequestBody BoardSaveDTO dto) {
    return ResponseEntity.ok().body(
        ResponseDTO.builder().code(ResCodeMsg.OK.getCode()).msg(ResCodeMsg.OK)
            .data(boardService.saveBoard(dto)).build());
  }

  @PutMapping
  public ResponseEntity<?> modifyBoard(@RequestBody BoardSaveDTO dto) {
    return ResponseEntity.ok().body(
        ResponseDTO.builder().code(ResCodeMsg.OK.getCode()).msg(ResCodeMsg.OK)
            .data(boardService.modifyBoard(dto)).build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteBoard(@PathVariable Long id) {
    return ResponseEntity.ok().body(
        ResponseDTO.builder().code(ResCodeMsg.OK.getCode()).msg(ResCodeMsg.OK)
            .data(boardService.deleteBoard(id)).build());
  }

  @GetMapping
  public ResponseEntity<?> getBoard(Pageable pageable) {
    return ResponseEntity.ok().body(
        ResponseDTO.builder().code(ResCodeMsg.OK.getCode()).msg(ResCodeMsg.OK)
            .data(boardService.getBoardList(pageable)).build());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getBoardById(@PathVariable Long id) {
    return ResponseEntity.ok().body(
        ResponseDTO.builder().code(ResCodeMsg.OK.getCode()).msg(ResCodeMsg.OK)
            .data(boardService.findBoardDetailById(id)).build());
  }

}
