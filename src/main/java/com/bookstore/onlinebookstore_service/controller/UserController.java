package com.bookstore.onlinebookstore_service.controller;

import com.bookstore.onlinebookstore_service.dto.user.UpdateProfileDTO;
import com.bookstore.onlinebookstore_service.dto.user.UserResponseDTO;
import com.bookstore.onlinebookstore_service.entity.User;
import com.bookstore.onlinebookstore_service.service.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceInterface userService;

    @GetMapping(value = "/profile",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> getProfile(
            @AuthenticationPrincipal OAuth2User oauth2User) {

        String email = oauth2User.getAttribute("email");
        String name = oauth2User.getAttribute("name");

        return ResponseEntity.ok(userService.getOrCreateGoogleUser(email, name));
    }

    @PutMapping("/profile")
    public ResponseEntity<UserResponseDTO> updateProfile(
            @RequestBody UpdateProfileDTO request) {

        return ResponseEntity.ok(
                userService.updateProfile(request)
        );
    }
}
