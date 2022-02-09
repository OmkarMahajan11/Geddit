package com.example.redditclone.dtos;

import com.example.redditclone.models.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	private String username;
	private String email;
	private String password;
	private RoleType role = RoleType.USER;
}
