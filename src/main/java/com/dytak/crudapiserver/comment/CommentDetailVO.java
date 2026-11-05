package com.dytak.crudapiserver.comment;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Date;
import java.util.Optional;
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


  public static CommentDetailVO of(Optional<Comment> comment) {
    return CommentDetailVO.builder()
        .boardId(comment.get().getBoard().getId())
        .id(comment.get().getId())
        .content(comment.get().getContent())
        .writerId(comment.get().getWriterId())
        .crtDate(comment.get().getCrtDate())
        .modDate(comment.get().getModDate()).build();
  }
}
