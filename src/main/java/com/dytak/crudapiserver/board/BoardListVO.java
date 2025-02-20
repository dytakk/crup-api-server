package com.dytak.crudapiserver.board;

import com.dytak.crudapiserver.comment.Comment;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardListVO {

  private Long id;
  private String title;
  private Long writerId;
  private Date crtDate;
  private Date modDate;
  private Long commentCount;

  public static Page<BoardListVO> of(Page<Board> board) {
    return board.map(v -> BoardListVO.builder()
        .id(v.getId())
        .title(v.getTitle())
        .writerId(v.getWriterId())
        .crtDate(v.getCrtDate())
        .modDate(v.getModDate())
        .commentCount(v.getComment().stream().map(Comment::getId).count()).build());
  }
}
