package com.dytak.crudapiserver.comment;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentDetailVO {

  private Long boardId;
  private Long id;
  private String content;
  private Long writerId;
  private Date crtDate;
  private Date modDate;


  public static CommentDetailVO of(Comment comment) {
    return CommentDetailVO.builder()
        .boardId(comment.getBoard().getId())
        .id(comment.getId())
        .content(comment.getContent())
        .writerId(comment.getWriterId())
        .crtDate(comment.getCrtDate())
        .modDate(comment.getModDate()).build();
  }
}
