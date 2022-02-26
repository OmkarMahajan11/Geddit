package com.example.redditclone.services;

import com.example.redditclone.exceptions.UserNotFoundException;
import com.example.redditclone.models.User;
import com.example.redditclone.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
			.orElseThrow(() -> new UserNotFoundException("Username: " + username));
	}

	@Transactional
	public void createUser(User user) {
		userRepository.save(user);
	}
}
