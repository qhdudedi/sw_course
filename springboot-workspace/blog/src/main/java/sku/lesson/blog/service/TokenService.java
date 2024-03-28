package sku.lesson.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sku.lesson.blog.config.jwt.TokenProvider;
import sku.lesson.blog.domain.User;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) throws IllegalAccessException {
        if(!tokenProvider.validToken(refreshToken)){
            throw new IllegalAccessException("Unexpected token");   //유효성 검사 실패 시 예외 발생
        }
        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }

}
