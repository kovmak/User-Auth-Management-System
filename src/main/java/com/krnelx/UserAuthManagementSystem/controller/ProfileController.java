package com.krnelx.UserAuthManagementSystem.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal Object principal, Model model) {
        String username = null;
        String email = null;

        if (principal instanceof OAuth2User oauthUser) {
            username = oauthUser.getAttribute("name");
            email = oauthUser.getAttribute("email");
        } else if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        }

        if (username != null) {
            model.addAttribute("username", username);
            model.addAttribute("email", email);
            return "profile";
        }

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }
}