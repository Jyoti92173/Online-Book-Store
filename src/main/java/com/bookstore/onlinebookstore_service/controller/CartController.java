package com.bookstore.onlinebookstore_service.controller;

import com.bookstore.onlinebookstore_service.dto.cart.CartItemRequestDTO;
import com.bookstore.onlinebookstore_service.entity.Cart;
import com.bookstore.onlinebookstore_service.service.CartServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartServiceInterface cartService;

    @GetMapping
    public ResponseEntity<Cart> getCart(Authentication authentication) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                cartService.getCart(email)
        );
    }
    @PostMapping("/items")
    public ResponseEntity<Cart> addItem(
            Authentication authentication,
            @RequestBody CartItemRequestDTO request) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                cartService.addItem(email, request)
        );
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> removeItem(
            Authentication authentication,
            @PathVariable Integer id) {

        String email = authentication.getName();

        cartService.removeItem(email, id);

        return ResponseEntity.ok("Item removed from cart");
    }

}
