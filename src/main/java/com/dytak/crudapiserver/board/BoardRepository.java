package com.dytak.crudapiserver.board;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends CrudRepository<Board,Long> {

    /* Paging사용시 필요할 수도 있는 Query*/
    //  @Query(value = "SELECT DISTINCT b FROM Board b LEFT JOIN b.comment",
    //        countQuery = "SELECT COUNT(b) FROM Board b")

   // @EntityGraph(attributePaths = {"comment"})
    //@Query("SELECT b FROM Board b")
    Page<Board>  findAll(Pageable pageable);


    Board findBoardByWriterId(Long id);
}
