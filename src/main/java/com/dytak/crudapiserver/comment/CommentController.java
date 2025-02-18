package com.dytak.crudapiserver.comment;


import com.dytak.crudapiserver.common.ResCodeMsg;
import com.dytak.crudapiserver.common.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/comment")
public class CommentController {

  private final CommentService commentService;

  @Autowired
  CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @PostMapping
  public ResponseEntity<?> saveComment(@RequestBody CommentSaveDTO dto) {
    return ResponseEntity.ok().body(
        ResponseDTO.builder().code(ResCodeMsg.OK.getCode()).msg(ResCodeMsg.OK)
            .data(commentService.saveComment(dto)).build());
  }

  @PutMapping
  public ResponseEntity<?> modifyComment(@RequestBody CommentSaveDTO dto) {
    return ResponseEntity.ok().body(
        ResponseDTO.builder().code(ResCodeMsg.OK.getCode()).msg(ResCodeMsg.OK)
            .data(commentService.modifyComment(dto)).build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteComment(@PathVariable Long id) {
    return ResponseEntity.ok().body(
        ResponseDTO.builder().code(ResCodeMsg.OK.getCode()).msg(ResCodeMsg.OK)
            .data(commentService.deleteComment(id)).build());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getCommentById(@PathVariable Long id) {
    return ResponseEntity.ok().body(
        ResponseDTO.builder().code(ResCodeMsg.OK.getCode()).msg(ResCodeMsg.OK)
            .data(commentService.findCommentDetailById(id)).build());
  }

}
