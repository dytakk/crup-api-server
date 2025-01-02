package com.dytak.crudapiserver.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.NoSuchAlgorithmException;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }

    @PostMapping("/member")
    public ResponseEntity<?> saveMember(@RequestBody MemberSaveDTO dto) throws NoSuchAlgorithmException {
        return ResponseEntity.ok().body(memberService.saveMember(dto));
    }

    @GetMapping("/member")
    public void findAllMember(){
    }
}
