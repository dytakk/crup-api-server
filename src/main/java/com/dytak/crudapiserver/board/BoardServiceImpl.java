package com.dytak.crudapiserver.board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

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
    Board board = boardRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
    return BoardDetailVO.of(board);
  }

  
  public Long saveBoard(BoardSaveDTO dto) {
    return boardRepository.save(dto.toEntity()).getId();
  }

  @Transactional
  public Long modifyBoard(BoardSaveDTO dto) {
    Board board = boardRepository.findById(dto.getId())
        .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
    return board.modifyBoard(dto.getTitle(), dto.getContent());
  }

  public Long deleteBoard(Long id) {
    boardRepository.deleteById(id);
    return id;
  }
}
