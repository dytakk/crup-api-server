package com.dytak.crudapiserver.board;


import com.dytak.crudapiserver.comment.Comment;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long writerId;
    private Date crtDate;
    private Date modDate;
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    @BatchSize(size=50)
    List<Comment> comment = new ArrayList<>();
}
