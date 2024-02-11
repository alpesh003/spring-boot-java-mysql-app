package com.alpesh.springbootjavamysqlapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/")
    public RedirectView redirectToWelcome() {
        return new RedirectView("/api/welcome");
    }

    @GetMapping("/welcome")
    public String welcomeUser() {
        return "Welcome to this app!";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String welcomeRegisteredUser(@AuthenticationPrincipal UserDetails userDetails) {
        return "Welcome Registered User .. " + userDetails.getUsername() + " with role/s " + userDetails.getAuthorities();
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcomeAdminUser(@AuthenticationPrincipal UserDetails userDetails) {
        return "Welcome Admin User .. " + userDetails.getUsername() + " with role/s " + userDetails.getAuthorities();
    }

}
