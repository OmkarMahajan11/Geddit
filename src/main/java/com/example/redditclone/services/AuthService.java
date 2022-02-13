package com.example.redditclone.services;

import com.example.redditclone.dtos.RegisterRequest;
import com.example.redditclone.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	public void register(RegisterRequest registerRequest) {
		User user = new User();
		user.setUsername(registerRequest.getUsername());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setCreatedAt(Instant.now());
		userService.createUser(user);
	}
}
