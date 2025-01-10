package com.dytak.crudapiserver.comment;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@org.springframework.stereotype.Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    CommentService(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }


    public CommentDetailDTO findCommentDetailById(Long id){
        Comment comment = commentRepository.findById(id).get();
        return CommentDetailDTO.of(comment);

    }
    public Long saveComment(CommentSaveDTO dto){
        return  commentRepository.save(dto.toEntity()).getId();
    }

    public Long modifyComment(CommentSaveDTO dto){
        return  commentRepository.save(dto.toEntity()).getId();
    }

    public Long deleteComment(Long id){
        commentRepository.deleteById(id);
        return id;
    }
}
