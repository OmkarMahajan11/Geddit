package com.example.redditclone.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.redditclone.config.AuthConfigConstants;
import com.example.redditclone.dtos.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try {
			LoginRequest creds = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);

			return authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
					creds.getUsername(),
					creds.getPassword(),
					new ArrayList<>()
				)
			);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
		String token = JWT.create()
			.withSubject(((User) auth.getPrincipal()).getUsername())
			.withExpiresAt(new Date(System.currentTimeMillis() + AuthConfigConstants.EXPIRATION_TIME))
			.sign(Algorithm.HMAC512(AuthConfigConstants.SECRET.getBytes()));

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(
			"{\"" + AuthConfigConstants.HEADER_STRING + "\":\"" + AuthConfigConstants.TOKEN_PREFIX + token + "\"}"
		);
	}
}
