package com.bookstore.onlinebookstore_service.service;

import com.bookstore.onlinebookstore_service.dto.auth.AuthResponseDTO;
import com.bookstore.onlinebookstore_service.dto.auth.LoginRequestDTO;
import com.bookstore.onlinebookstore_service.dto.auth.RegisterRequestDTO;

public interface AuthServiceInterface {

    AuthResponseDTO register(RegisterRequestDTO request);

    AuthResponseDTO login(LoginRequestDTO request);
}
