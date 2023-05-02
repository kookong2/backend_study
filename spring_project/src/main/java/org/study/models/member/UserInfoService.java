package org.study.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.study.entities.User;
import org.study.repositories.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User member = repository.findByUserEmail(username);

        if (member == null) {
            throw new UsernameNotFoundException(username);
        }
        
        // 사용자 권한 
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(member.getRole().toString()));

        return UserInfo.builder()
                .userNo(member.getUserNo())
                .userEmail(member.getUserEmail())
                .userNm(member.getUserNm())
                .userNickNm(member.getUserNickNm())
                .userPw(member.getUserPw())
                .cellPhone(member.getCellPhone())
                .authorities(authorities) // 사용자 권한 설정
                .build();
    }
}
