package com.dytak.crudapiserver.board;

import com.dytak.crudapiserver.comment.Comment;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardListDTO {

    private Long id;
    private String title;
    //private String content;
    private Long writerId;
    private Date crtDate;
    private Date modDate;
    //기존 private List<Comment> comment
    private Long commentCount;

    public static Page<BoardListDTO> of(Page<Board> board){
        return board.map(v->BoardListDTO.builder()
                .id(v.getId())
                .title(v.getTitle())
                .writerId(v.getWriterId())
                .crtDate(v.getCrtDate())
                .modDate(v.getModDate())
                .commentCount(v.getComment().stream().map(Comment::getId).count())
                .build());
    }
}
