package com.example.redditclone.mappers;

import com.example.redditclone.dtos.RegisterRequest;
import com.example.redditclone.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
	@Mapping(target = "password", ignore = true)
	User mapRegisterRequestToUser(RegisterRequest registerRequest);
}
