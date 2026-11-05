package com.dytak.crudapiserver.member;


import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public MemberServiceImpl(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
    this.memberRepository = memberRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public String saveMember(MemberSaveDTO dto) throws NoSuchAlgorithmException {
    String password = passwordEncoder.encode(dto.getPassword());
    memberRepository.save(dto.toEntity(password));
    return dto.getUsername();
  }

  public Iterable<Member> findAllMembers() {

    return (List<Member>) memberRepository.findAll();
  }

}
