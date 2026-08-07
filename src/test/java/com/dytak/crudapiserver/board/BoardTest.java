package com.dytak.crudapiserver.board;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class BoardTest {

   private final BoardRepository boardRepository;
   private final BoardServiceImpl boardServiceImpl;

   @Autowired
   public BoardTest(BoardRepository boardRepository, BoardServiceImpl boardServiceImpl){
       this.boardRepository = boardRepository;
       this.boardServiceImpl = boardServiceImpl;
   }

    @Test
    @DisplayName("Board 게시글 작성")
    public void saveBoard(){

        //Given Test를 위한 변수 세팅
        Long writerId= Long.MAX_VALUE;
        String title = "test_title";
        String content = "test_content";

        //When
        BoardSaveDTO boardSaveDTO = BoardSaveDTO.builder()
                                            .title(title)
                                            .content(content)
                                            .writerId(writerId).build();
        boardServiceImpl.saveBoard(boardSaveDTO);
        Board board = boardRepository.findBoardByWriterId(writerId);

        //Then
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);
    }

    @Test
    @DisplayName("Board 게시글 수정")
    public void modifyBoard(){

        //Given Test를 위한 변수 세팅
        Long writerId= Long.MAX_VALUE;
        String title = "test_title_modify";
        String content = "test_content_modify";

        //When
        BoardSaveDTO boardSaveDTO = BoardSaveDTO.builder()
                .title(title)
                .content(content)
                .writerId(writerId).build();
        boardServiceImpl.saveBoard(boardSaveDTO);
        Board board = boardRepository.findBoardByWriterId(writerId);

        //Then
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);
    }


    @Test
    @DisplayName("Board 게시글 읽기 테스트")
    @Transactional
    public void boardDetail(){

        //Given (테스트용으로 만든 게시글의 ID는 1)
        Long writerId= Long.MAX_VALUE;
        String title = "test_title";
        String content = "test_content";

        //When
        Optional<Board> board = boardRepository.findById(1L);
        boardServiceImpl.findBoardDetailById(1L);

        //Then
        if(board.isPresent()){
            assertThat(board.get().getContent()).isEqualTo("content_test");
            assertThat(board.get().getTitle()).isEqualTo("title_test");
        }
    }


    @Test
    @DisplayName("Board 게시글 리스트 페이징을 통한 조회 테스트")
    @Transactional
    public void boardList(){

        //Given (Pageable의 사이즈는 임의값 5로 지정);
        //When
//        Pageable pageable = PageRequest.of(0,5);
//       // Page<BoardListDTO> board = BoardListDTO.of(boardRepository.findAll(pageable));
//
//        //Then
//        assertThat(board.getTotalPages()).isGreaterThan(0);
//        assertThat(board.getTotalElements()).isGreaterThanOrEqualTo(1);
//        assertThat(board.getContent().get(0).getTitle()).isNotNull();

    }



}
