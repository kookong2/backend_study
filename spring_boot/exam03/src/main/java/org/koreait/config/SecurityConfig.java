package org.koreait.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/member/login")
                .defaultSuccessUrl("/")
                .usernameParameter("userId")
                .passwordParameter("userPw")
                .failureUrl("/member/login?success=false")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/member/login");

        http.authorizeHttpRequests()
                .requestMatchers("/", "/exam/**", "/member/login", "/member/join", "/error/**").permitAll() // 모든 회원
                .requestMatchers("/admin/**").hasAuthority("ADMIN")  // 관리자만 가능한 URL
                .anyRequest().authenticated(); // 로그인한 회원

        http.exceptionHandling()
                .authenticationEntryPoint((req, res, e) -> {
                    String URI = req.getRequestURI();
                    String redirectUrl = "/member/login"; // 로그인 페이지
                    if (URI.indexOf("/admin") != -1) { // 관리자 페이지, 401
                        redirectUrl = "/error/401"; // 권한 없음 표기
                    }

                    res.sendRedirect(req.getContextPath() + redirectUrl);
                });

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
       return w -> w.ignoring().requestMatchers("/images/**", "/js/**", "/css/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
