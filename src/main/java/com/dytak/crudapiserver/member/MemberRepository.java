package com.dytak.crudapiserver.member;

import io.micrometer.common.lang.NonNullApi;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@NonNullApi
public interface MemberRepository extends CrudRepository<Member, Long> {

  Optional<Member> findByUsername(String username);

  Iterable<Member> findAll();
}
