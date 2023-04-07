package org.koreait.models.member;

import lombok.RequiredArgsConstructor;
import org.koreait.commons.constants.Role;
import org.koreait.controllers.members.Join;
import org.koreait.entities.Member;
import org.koreait.repositories.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberJoinService {

    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void join(Join join) {

        String hash = passwordEncoder.encode(join.getUserPw());

        Member member = Member.builder()
                .userId(join.getUserId())
                .userPw(hash)
                .userNm(join.getUserNm())
                .email(join.getEmail())
                .mobile(join.getMobile())
                .role(Role.USER)
                .build();

        repository.save(member);
    }

}
