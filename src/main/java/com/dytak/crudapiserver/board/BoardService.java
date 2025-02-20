package com.dytak.crudapiserver.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BoardService {

  Page<BoardListVO> getBoardList(Pageable pageable);
  
  BoardDetailVO findBoardDetailById(Long id);

  Long saveBoard(BoardSaveDTO dto);

  Long modifyBoard(BoardSaveDTO dto);

  Long deleteBoard(Long id);
}
