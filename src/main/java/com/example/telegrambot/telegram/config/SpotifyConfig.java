package com.example.telegrambot.telegram.config;

import com.example.telegrambot.spotify.config.TokenRefreshingBeanPostProcessor;
import com.example.telegrambot.spotify.repository.UserCodeRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.enums.AuthorizationScope;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

@Configuration
@Getter
public class SpotifyConfig {

    @Value("${spotify.client_id}")
    private String clientId;

    @Value("${spotify.client_secret}")
    private String clientSecret;

    @Value("${bot.path}" + "${spotify.redirect_uri}")
    private String redirectUri;

    @Bean
    public TokenRefreshingBeanPostProcessor tokenRefreshingBeanPostProcessor(UserCodeRepository userCodeRepository) {
        return new TokenRefreshingBeanPostProcessor(userCodeRepository, this);
    }

}
