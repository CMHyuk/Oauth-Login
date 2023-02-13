package com.example.oauth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OauthController {

    private final CustomOAuth2UserService service;

    @PostMapping("/login")
    public OAuth2User oauthLogin(Authentication authentication) {
        OAuth2UserRequest request = (OAuth2UserRequest) authentication.getPrincipal();
        return service.loadUser(request);
    }

    @GetMapping("a")
    public String a() {
        return "/login";
    }
}
