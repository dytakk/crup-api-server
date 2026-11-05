package com.dytak.crudapiserver.member;


import static org.assertj.core.api.Assertions.assertThat;

import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class MemberTest {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public MemberTest(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
    this.memberRepository = memberRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Test
  @DisplayName("Member 조회")
  public void getMember() {
    //Given
    //When ( Test id 1이 주어짐 )
    String testUsername = "test_user";
    //Then
    assertThat(memberRepository.findByUsername(testUsername).get().getUsername()).isEqualTo(
        testUsername);
    System.out.println(
        "memberRepository = " + memberRepository.findByUsername(testUsername).get().getName());
  }

  @Test
  @DisplayName("Member 저장")
  public void saveMemberSet() throws NoSuchAlgorithmException {
    //Given

    //When
    String password = passwordEncoder.encode("PASSTEST");

    MemberSaveDTO dto = MemberSaveDTO.builder()
        .username("save_test_user")
        .name("저장테스트")
        .password(password)
        .grade("A")
        .mailAddress("test@test.com").build();

    memberRepository.save(dto.toEntity(password));

    //Then
    assertThat(memberRepository.findByUsername("save_test_user").get().getUsername()).isEqualTo(
        "save_test_user");
    Long delId = memberRepository.findByUsername("save_test_user").get().getId();

    //Then..After? (저장한 save_test_user를 삭제)
    memberRepository.deleteById(delId);
    assertThat(memberRepository.findById(delId)).isEmpty();
  }

}
