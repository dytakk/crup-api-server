package com.dytak.crudapiserver.member;


import java.security.NoSuchAlgorithmException;

public interface MemberService {

  public String saveMember(MemberSaveDTO dto) throws NoSuchAlgorithmException;

  public Iterable<Member> findAllMembers();

}
