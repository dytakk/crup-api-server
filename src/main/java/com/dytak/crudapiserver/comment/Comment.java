package com.dytak.crudapiserver.comment;

import com.dytak.crudapiserver.board.Board;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity(name = "comment")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 실제 DB에 FK로 잡혀 있는 boardId(board_id)를 Entity를 없앴다.
    // private Long boardId;
    private Long writerId;
    private String content;
    private Date crtDate;
    private Date modDate;
    @ManyToOne
    //@JoinColumn(name="board_id",insertable = false,nullable = false)
    private Board board;
}
