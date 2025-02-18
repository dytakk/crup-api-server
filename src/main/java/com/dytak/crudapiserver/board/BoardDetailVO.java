package com.dytak.crudapiserver.board;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardDetailVO {

  private Long id;
  private String title;
  private String content;
  private Long writerId;
  private Date crtDate;
  private Date modDate;
  //기존 private List<Comment> comment
  private List<CommentDTO> comment;

  @Builder
  @AllArgsConstructor
  @Getter
  public static class CommentDTO {

    private Long id;
    private Long writerId;
    private String content;
    private Date crtDate;
    private Date modDate;
  }

  public static BoardDetailVO of(Board board) {
    List<CommentDTO> commentList = board.getComment().stream().map(v -> CommentDTO.builder()
        .id(v.getId())
        .writerId(v.getWriterId())
        .content(v.getContent())
        .crtDate(v.getCrtDate())
        .modDate(v.getModDate()).build()).collect(Collectors.toList());
    return BoardDetailVO.builder()
        .id(board.getId())
        .title(board.getTitle())
        .content(board.getContent())
        .writerId(board.getWriterId())
        .crtDate(board.getCrtDate())
        .modDate(board.getModDate())
        .comment(commentList).build();
  }
}
