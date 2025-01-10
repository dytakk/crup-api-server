package com.dytak.crudapiserver.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    CommentController(CommentService commentService){
        this.commentService=commentService;
    }

    @PostMapping
    public ResponseEntity<?> saveComment(@RequestBody CommentSaveDTO dto){
        return ResponseEntity.ok().body(commentService.saveComment(dto));
    }

    @PutMapping
    public ResponseEntity<?> modifyComment(@RequestBody CommentSaveDTO dto){
        return ResponseEntity.ok().body(commentService.modifyComment(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id){
        return ResponseEntity.ok().body(commentService.deleteComment(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable Long id){
        return ResponseEntity.ok().body(commentService.findCommentDetailById(id));
    }

}
