package com.bookstore.onlinebookstore_service.controller;

import com.bookstore.onlinebookstore_service.dto.auth.AuthResponseDTO;
import com.bookstore.onlinebookstore_service.dto.auth.LoginRequestDTO;
import com.bookstore.onlinebookstore_service.dto.auth.RefreshTokenRequestDTO;
import com.bookstore.onlinebookstore_service.dto.auth.RegisterRequestDTO;
import com.bookstore.onlinebookstore_service.security.JwtUtil;
import com.bookstore.onlinebookstore_service.service.AuthServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceInterface authService;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDTO> registerUser(
            @RequestBody RegisterRequestDTO request) {

        return ResponseEntity.ok(
                authService.register(request)
        );
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponseDTO> authenticateUser(
            @RequestBody LoginRequestDTO request) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }

    
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponseDTO> refreshToken(@RequestBody
                                                        RefreshTokenRequestDTO request){
        return ResponseEntity.ok(
                authService.refresh(request)
        );
    }
}


