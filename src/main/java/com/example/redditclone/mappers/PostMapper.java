package com.example.redditclone.mappers;

import com.example.redditclone.dtos.PostRequest;
import com.example.redditclone.dtos.PostResponse;
import com.example.redditclone.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

	@Mapping(target = "postId", ignore = true)
	@Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
	Post mapPostRequestToPost(PostRequest postRequest);

	@Mapping(target = "id", source = "post.postId")
	PostResponse mapPostToPostResponse(Post post);
}
