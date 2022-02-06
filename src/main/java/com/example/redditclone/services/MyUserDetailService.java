package com.example.redditclone.services;

import com.example.redditclone.models.RoleType;
import com.example.redditclone.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

	private final UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userService.findByUsername(username);

		return new org.springframework.security.core.userdetails.User(
			user.getUsername(), user.getPassword(), getAuthorities(user.getRole())
		);
	}

	private Collection<? extends GrantedAuthority> getAuthorities(RoleType role) {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}
}
