package com.example.redditclone.services;

import com.example.redditclone.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

	private final UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userService.findByUsername(username);

		return new org.springframework.security.core.userdetails.User(
			user.getUsername(), user.getPassword(), new ArrayList<>()
		);
	}
}
