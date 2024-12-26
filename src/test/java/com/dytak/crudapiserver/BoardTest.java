package com.dytak.crudapiserver;

import com.dytak.crudapiserver.board.BoardRepository;
import com.dytak.crudapiserver.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class BoardTest {

   private final BoardRepository boardRepository;

   @Autowired
   public BoardTest(BoardRepository boardRepository){
       this.boardRepository = boardRepository;

   }


    @Test
    @DisplayName("Board 게시글 읽기 테스트")
    public void test(){

       //Given (테스트용으로 만든 게시글의 ID는 1)
        Long boardId=1L;

        //When
        Optional<Board> board = boardRepository.findById(boardId);

        //Then
        if(board.isPresent()){
            assertThat(board.get().getContent()).isEqualTo("content_test");
            assertThat(board.get().getTitle()).isEqualTo("title_test");
        }
    }
}
