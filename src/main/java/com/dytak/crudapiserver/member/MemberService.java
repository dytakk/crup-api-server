package com.dytak.crudapiserver.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;


@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    public String saveMember(MemberSaveDTO dto) throws NoSuchAlgorithmException {
        memberRepository.save(dto.toEntity());
        return dto.getUsername();
    }


}
