package com.dytak.crudapiserver.comment;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {


}
