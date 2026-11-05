package com.dytak.crudapiserver.authentication;

import com.dytak.crudapiserver.member.Member;
import com.dytak.crudapiserver.member.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/*UserDetails 객체를 기반으로 Member에 대한 정보를 활용하는 Service*/
@Service
public class CustomUserDetailService implements UserDetailsService {

  private final MemberRepository memberRepository;

  private CustomUserDetailService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //Username을 기준으로 UserDetails 호출

    Member member = memberRepository.findByUsername(username)
        .orElseThrow(() ->
            new UsernameNotFoundException("회원 없음"));

    return new CustomUserDetails(member);
  }
}
