package com.dytak.crudapiserver.comment;


import com.dytak.crudapiserver.board.Board;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentDTO {

    private Long id;
    private Long boardId;
    private Long writerId;
    private String content;
    public Comment toEntity(){
        return Comment.builder().writerId(writerId).content(content).build();
    }

}
