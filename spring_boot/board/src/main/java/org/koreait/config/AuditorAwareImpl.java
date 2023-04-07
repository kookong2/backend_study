package org.koreait.config;

import org.koreait.models.member.MemberDetails;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Long userNo = null;
        if(auth != null && auth.getPrincipal() instanceof MemberDetails){
            MemberDetails memberDetails = (MemberDetails) auth.getPrincipal();
            userNo = memberDetails.getUserNo();
        }

        return Optional.ofNullable(userNo);
    }
}
