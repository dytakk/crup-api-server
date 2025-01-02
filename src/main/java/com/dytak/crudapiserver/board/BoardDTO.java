package com.dytak.crudapiserver.board;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BoardDTO {

    public Long id;
    public String title;
    public String content;
    public Long writer_id;
    public Board toEntity(){
        return Board.builder().id(id).content(content).title(title).writer_id(writer_id).build();
    }

}
