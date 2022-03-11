package com.example.redditclone.mappers;

import com.example.redditclone.dtos.PostRequest;
import com.example.redditclone.dtos.PostResponse;
import com.example.redditclone.models.Post;
import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

	@Mapping(target = "postId", ignore = true)
	@Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
	@Mapping(target = "author", source = "user")
	@Mapping(target = "description", source = "postRequest.description")
	Post mapPostRequestToPost(PostRequest postRequest, Subreddit subreddit, User user);

	@Mapping(target = "id", source = "postId")
	@Mapping(target = "subredditName", expression = "java(post.getSubreddit().getName())")
	@Mapping(target = "authorName", expression = "java(post.getAuthor().getUsername())")
	PostResponse mapPostToPostResponse(Post post);
}
