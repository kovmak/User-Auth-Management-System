package com.krnelx.UserAuthManagementSystem.controller;

import com.krnelx.UserAuthManagementSystem.model.User;
import com.krnelx.UserAuthManagementSystem.repository.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuth2Controller {

    private final UserRepository userRepository;

    public OAuth2Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/oauth2/callback")
    public String oauth2Callback(@AuthenticationPrincipal OAuth2User principal) {
        String username = principal.getAttribute("name");
        String email = principal.getAttribute("email");
        String oauth2Id = principal.getAttribute("sub");
        String provider = "google";

        User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setOauth2Provider(provider);
            user.setOauth2Id(oauth2Id);
            userRepository.save(user);
        }

        return "redirect:/profile";
    }
}