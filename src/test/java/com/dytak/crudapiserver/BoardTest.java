package com.dytak.crudapiserver;

import com.dytak.crudapiserver.board.BoardRepository;
import com.dytak.crudapiserver.board.BoardService;
import com.dytak.crudapiserver.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class BoardTest {

   private final BoardRepository boardRepository;
   private final BoardService boardService;

   @Autowired
   public BoardTest(BoardRepository boardRepository,BoardService boardService){
       this.boardRepository = boardRepository;
       this.boardService=boardService;
   }


    @Test
    @DisplayName("Board 게시글 리스트 페이징을 통한 조회 테스트")
    public void boardList(){

        //Given (Pageable의 사이즈는 임의값 5로 지정);
        //When
        Pageable pageable = PageRequest.of(0,5);
        Page<Board> board = boardRepository.findAll(pageable);

        //Then
        assertThat(board.getTotalPages()).isGreaterThan(0);
        assertThat(board.getTotalElements()).isGreaterThanOrEqualTo(1);
        assertThat(board.getContent().get(0).getTitle()).isNotNull();

    }


    @Test
    @DisplayName("Board 게시글 읽기 테스트")
    public void boardDetail(){

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
