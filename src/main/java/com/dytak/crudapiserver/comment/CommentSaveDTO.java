package com.dytak.crudapiserver.comment;


import com.dytak.crudapiserver.board.Board;
import com.dytak.crudapiserver.board.BoardSaveDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentSaveDTO {

    private Long id;
    public String content;
    public Long writerId;
    public Long boardId;
    public Comment toEntity(){
        return Comment.builder()
                .id(id)
                .content(content)
                .writerId(writerId)
                .board(BoardSaveDTO.builder()
                        .id(boardId).build().toEntity()).build();
    }

}
