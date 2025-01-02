package com.dytak.crudapiserver.board;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardDTO {

    public Long id;
    public String title;
    public String content;
    public Long writerId;
    public Board toEntity(){
        return Board.builder().id(id).content(content).title(title).writer_id(writerId).build();
    }

}
