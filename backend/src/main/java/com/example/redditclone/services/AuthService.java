package com.example.redditclone.services;

import com.example.redditclone.dtos.RegisterRequest;
import com.example.redditclone.mappers.UserMapper;
import com.example.redditclone.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	private final UserMapper userMapper;

	public void register(RegisterRequest registerRequest) {
		User user = userMapper.mapRegisterRequestToUser(registerRequest);
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		userService.createUser(user);
	}

	public User getCurrentUser() {
		return userService.findByUsername(
			SecurityContextHolder.getContext()
				.getAuthentication().getName()
		);
	}
}
