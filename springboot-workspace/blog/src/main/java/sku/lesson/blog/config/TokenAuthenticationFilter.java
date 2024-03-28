package sku.lesson.blog.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import sku.lesson.blog.config.jwt.TokenProvider;

import java.io.IOException;

/** 엑세스 토큰 값이 담긴 Authorization 헤더 값을 가져온 뒤 엑세스 토큰이 유효하다면 인증정보 설정 */
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private final TokenProvider tokenProvider;
    private final static String HEADER_AUTHORIAZTION = "Authorization";
    private final static String TOKEN_PREFLX = "Bearer";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
                                    throws ServletException, IOException{

        //요청 헤더의 Authorization 키 값 조회
        String authorizationHeader =  request.getHeader(HEADER_AUTHORIAZTION);
        //가져온 값에서 접두사 제거
        String token = getAccessToken(authorizationHeader);

        if(tokenProvider.validToken(token)){
            Authentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
    private String getAccessToken(String authorizationHeader){
        if(authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFLX)){
            return authorizationHeader.substring(TOKEN_PREFLX.length());
        }
        return null;
    }
}
