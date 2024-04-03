package sku.lesson.blog.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import sku.lesson.blog.service.UserDetailService;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

    private final UserDetailService userDetailService;

    /** spring security 모든 기능을 사용하지 않도록 설정 */
    @Bean
    public WebSecurityCustomizer configure(){
        return (web)-> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers("/static/**");
    }
    /** 특정 Http 요청에 대한 웹 기반 보안 구성*/
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/login", "/signup", "/user").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .successHandler((request, response, authentication) -> {
                                    // 로그인 성공 시 로직을 추가
                                    response.sendRedirect("/articles");
                                })
                                .failureHandler((request, response, exception) -> {
                                    // 로그인 실패 시 로직을 추가
                                    response.sendRedirect("/login?error");
                                })
                )
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/login")
                                .invalidateHttpSession(true)
                )
                .csrf(csrf ->
                        csrf.disable()
                )
                .build();
    }

    /**인증 관리자 관련 설정*/
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }
    /**패스워드 인코더로 사용할 빈 등록*/
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
