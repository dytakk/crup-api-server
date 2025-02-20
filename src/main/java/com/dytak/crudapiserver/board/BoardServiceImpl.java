package com.dytak.crudapiserver.board;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;

  @Autowired
  BoardServiceImpl(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  public Page<BoardListVO> getBoardList(Pageable pageable) {
    return BoardListVO.of(boardRepository.findAll(pageable));
  }

  public BoardDetailVO findBoardDetailById(Long id) {
    //TODO:Null체크 어떻게할까?
    //Board board = boardRepository.findBoardById(id);
    //Optional<Board> board = Optional.ofNullable(boardRepository.findBoardById(id));
    if (Optional.ofNullable(boardRepository.findBoardById(id)).isPresent()) {
      Board board = boardRepository.findBoardById(id);
      return BoardDetailVO.of(board);
    } else {
      return BoardDetailVO.builder().build();
    }
  }

  public Long saveBoard(BoardSaveDTO dto) {
    return boardRepository.save(dto.toEntity()).getId();
  }

  public Long modifyBoard(BoardSaveDTO dto) {
    return boardRepository.save(dto.toEntity()).getId();
  }

  public Long deleteBoard(Long id) {
    boardRepository.deleteById(id);
    return id;
  }
}
