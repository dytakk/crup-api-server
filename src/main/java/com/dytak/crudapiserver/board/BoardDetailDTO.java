package com.dytak.crudapiserver.board;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardDetailDTO {

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
    public static class CommentDTO{
        private Long id;
        private Long writerId;
        private String content;
        private Date crtDate;
        private Date modDate;
    }
    public static BoardDetailDTO of(Board board){
       List<CommentDTO> commentList = board.getComment().stream().map(v->CommentDTO.builder()
               .id(v.getId())
               .writerId(v.getWriterId())
               .content(v.getContent())
               .crtDate(v.getCrtDate())
               .modDate(v.getModDate()).build()).collect(Collectors.toList());
       return BoardDetailDTO.builder()
               .id(board.getId())
               .title(board.getTitle())
               .content(board.getContent())
               .writerId(board.getWriterId())
               .crtDate(board.getCrtDate())
               .modDate(board.getModDate())
               .comment(commentList).build();
    }
}
