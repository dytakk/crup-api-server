package com.dytak.crudapiserver.comment;

import com.dytak.crudapiserver.board.Board;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentDetailDTO {

    private Long id;
    private String content;
    private Long writerId;
    private Date crtDate;
    private Date modDate;


    public static CommentDetailDTO of(Comment comment){
       return CommentDetailDTO.builder()
               .id(comment.getId())
               .content(comment.getContent())
               .writerId(comment.getWriterId())
               .crtDate(comment.getCrtDate())
               .modDate(comment.getModDate()).build();
    }
}
