package com.bookstore.onlinebookstore_service.service.impl;

import com.bookstore.onlinebookstore_service.dto.auth.AuthResponseDTO;
import com.bookstore.onlinebookstore_service.dto.auth.LoginRequestDTO;
import com.bookstore.onlinebookstore_service.dto.auth.RefreshTokenRequestDTO;
import com.bookstore.onlinebookstore_service.dto.auth.RegisterRequestDTO;
import com.bookstore.onlinebookstore_service.entity.User;
import com.bookstore.onlinebookstore_service.enums.Role;
import com.bookstore.onlinebookstore_service.repository.UserRepository;
import com.bookstore.onlinebookstore_service.security.JwtUtil;
import com.bookstore.onlinebookstore_service.service.AuthServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthServiceInterface {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponseDTO register(RegisterRequestDTO request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.CUSTOMER);
        user.setVerified(false);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);

        AuthResponseDTO responseDTO = new AuthResponseDTO();
        responseDTO.setMessage("Successfully Registered");
        return  responseDTO;

    }

    @Override
    public AuthResponseDTO login (LoginRequestDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid email or password");
        }

        String accessToken = jwtUtil.generateAccessToken(user.getEmail());
        String refreshToken = jwtUtil.generateRefreshToken(user.getEmail());

        AuthResponseDTO response = new AuthResponseDTO();
        
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        response.setTokenType("Bearer");
        response.setMessage("Login successful");

        return response;
    }

    @Override
    public AuthResponseDTO refresh(RefreshTokenRequestDTO request) {
        return null;
    }


}
