package com.dytak.crudapiserver.board;


import io.micrometer.common.lang.NonNullApi;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@NonNullApi
public interface BoardRepository extends JpaRepository<Board, Long> {

  Page<Board> findAll(Pageable pageable);

  Optional<Board> findBoardByWriterId(Long id);

  Optional<Board> findById(Long id);
}
