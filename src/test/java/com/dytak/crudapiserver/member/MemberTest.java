package com.dytak.crudapiserver.member;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberTest {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberTest(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Test
    @DisplayName("Member 조회")
    public void getMember(){
        //Given
        //When ( Test id 1이 주어짐 )
        String testUsername = "test_user";
        //Then
        assertThat(memberRepository.findByUsername(testUsername).getUsername()).isEqualTo(testUsername);
        System.out.println("memberRepository = " + memberRepository.findByUsername(testUsername).getName());
    }

    @Test
    @DisplayName("Member 저장")
    public void saveMemberSet() throws NoSuchAlgorithmException {
        //Given
        MemberSaveDTO dto = MemberSaveDTO.builder()
                .username("save_test_user")
                .name("저장테스트")
                .password("PASSTEST")
                .grade("A")
                .mailAddress("test@test.com").build();

        //When
        memberRepository.save(dto.toEntity());

        //Then
        assertThat(memberRepository.findByUsername("save_test_user").getUsername()).isEqualTo("save_test_user");
        Long delId = memberRepository.findByUsername("save_test_user").getId();

        //Then..After? (저장한 save_test_user를 삭제)
        memberRepository.deleteById(delId);
        assertThat(memberRepository.findById(delId)).isEmpty();
    }

}
