package com.dytak.crudapiserver.comment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CommentTest {

    private final CommentRepository commentRepository;
    //private final CommentService commentService;

    @Autowired

    public CommentTest(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
        //  this.commentService = commentService;
    }


    @Test
    @BeforeEach
    @DisplayName("Comment 생성")
    public void saveComment() {

        //Given (Pageable의 사이즈는 임의값 5로 지정);
        //When
        CommentDTO dto = CommentDTO.builder().boardId(1L).content("comment_save_test").writerId(1L).build();
        Long id = commentRepository.save(dto.toEntity()).getId();

        Iterable <Comment> list = commentRepository.findAll();
        commentRepository.findById(id);
        assertThat(list).isNotNull();
        //Then
    }


    @Test
    @DisplayName("Comment 삭제")
    public void deleteComment() {

        //Given (Pageable의 사이즈는 임의값 5로 지정);
        //When
        //Long id = this.saveComment();
        //commentRepository.deleteById(id);
        //Then
        //assertThat(commentRepository.findById(id)).isEmpty();
    }


    @Test
    @DisplayName("Comment 조회")
    public void commentList() {

        //Given (Pageable의 사이즈는 임의값 5로 지정);
        //When

        Iterable <Comment> list = commentRepository.findAll();

        assertThat(list).isNotNull();

        //Then
    }


}
