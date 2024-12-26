package com.dytak.crudapiserver.board;

import com.dytak.crudapiserver.entity.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends CrudRepository<Board,Long> {

}
