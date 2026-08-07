package com.dytak.crudapiserver.comment;

public interface CommentService {

  CommentDetailVO findCommentDetailById(Long id);

  Long saveComment(CommentSaveDTO dto);

  Long modifyComment(CommentSaveDTO dto);

  Long deleteComment(Long id);

}
