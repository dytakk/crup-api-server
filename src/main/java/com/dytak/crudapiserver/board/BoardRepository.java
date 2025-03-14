package com.dytak.crudapiserver.board;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {
  
  Page<Board> findAll(Pageable pageable);

  Board findBoardByWriterId(Long id);

  Board findBoardById(Long id);
}
