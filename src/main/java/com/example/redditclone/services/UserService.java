package com.example.redditclone.services;

import com.example.redditclone.models.User;
import com.example.redditclone.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
			.orElseThrow();
	}
}
