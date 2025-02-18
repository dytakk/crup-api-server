package com.dytak.crudapiserver.comment;

public interface CommentService {

  public CommentDetailVO findCommentDetailById(Long id);

  public Long saveComment(CommentSaveDTO dto);

  public Long modifyComment(CommentSaveDTO dto);

  public Long deleteComment(Long id);

}
