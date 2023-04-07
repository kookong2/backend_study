package org.koreait.models.member;

import lombok.RequiredArgsConstructor;
import org.koreait.controllers.member.MemberJoin;
import org.koreait.entities.Member;
import org.koreait.repositories.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberJoinService {

    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void join(MemberJoin memberJoin) {

        // 비밀번호 해시 처리(BCrypt)
        String hash = passwordEncoder.encode(memberJoin.getUserPw());
        memberJoin.setUserPw(hash);

        // 회원 가입 처리
        Member member = MemberJoin.of(memberJoin);
        repository.save(member);
    }
}
