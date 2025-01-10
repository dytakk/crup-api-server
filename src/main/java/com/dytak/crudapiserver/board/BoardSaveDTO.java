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
public class BoardSaveDTO {

    private Long id;
    private String title;
    private String content;
    private Long writerId;
    public Board toEntity(){
        return Board.builder()
                        .id(id)
                        .content(content)
                        .title(title)
                        .writerId(writerId).build();
    }

}