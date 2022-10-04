package com.payhere.account;

import com.payhere.account.board.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final UserService userService; // 3

    @Override
    protected void configure(HttpSecurity http) throws Exception { // 5
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/","/loginPage", "/registerPage","/register_action","/login_fail","/resource/**").permitAll()
                // 로그인, 회원가입, 로그인 실패, 리소스 접근은 누구나 가능
                .antMatchers("/loginSuccess").hasRole("USER")
                .antMatchers("/loginSuccess").hasRole("ADMIN")
            .and()
            .formLogin()
                .loginPage("/loginPage") // 로그인 페이지 설정
                .loginProcessingUrl("/login_action")
                .defaultSuccessUrl("/login_success") // 로그인이 성공 시 리다이렉션
                .failureUrl("/login_fail") //로그인 실패 시 리다이렉션 (해당 form으로 error=true를 전송함.)
            .and()
            .logout()
                .logoutUrl("/logout_action")
                .logoutSuccessUrl("/loginPage")
                .invalidateHttpSession(true);
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { // 9
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

}