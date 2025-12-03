package org.science.prismatics.controller;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.dto.response.UserIdResponse;
import org.science.prismatics.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<UserIdResponse> issueNewUserId() {
        UserIdResponse response = authService.generateNewUserId();
        return ResponseEntity.ok(response);
    }
}
