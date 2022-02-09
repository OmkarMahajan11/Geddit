package com.example.redditclone.controllers;

import com.example.redditclone.dtos.RegisterRequest;
import com.example.redditclone.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
		authService.register(registerRequest);
		return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
	}
}
