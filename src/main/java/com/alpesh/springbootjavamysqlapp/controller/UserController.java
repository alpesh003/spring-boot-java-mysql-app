package com.alpesh.springbootjavamysqlapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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
    public String welcomeRegisteredUser() {
        return "Welcome Registered User";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcomeAdminUser() {
        return "Welcome Admin User";
    }

}
