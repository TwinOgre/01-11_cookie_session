package com.example._11.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getMember(String username) {
        Optional<Member> om = this.memberRepository.findByUsername(username);
        if(om.isEmpty()){
            throw new RuntimeException("없다");
        }

        return om.get();
    }
    public Member getMember(long id) {
        Optional<Member> om = this.memberRepository.findById(id);
        if(om.isEmpty()){
            throw new RuntimeException("없다");
        }

        return om.get();
    }

}
