package com.dytak.crudapiserver.board;


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

  public Page<BoardListDTO> getBoardList(Pageable pageable) {
    return BoardListDTO.of(boardRepository.findAll(pageable));
  }

  public BoardDetailVO findBoardDetailById(Long id) {
    return BoardDetailVO.of(boardRepository.findBoardById(id));
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
