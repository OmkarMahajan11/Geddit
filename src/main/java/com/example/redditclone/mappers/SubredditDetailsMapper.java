package com.example.redditclone.mappers;

import com.example.redditclone.dtos.SubredditDetailsDto;
import com.example.redditclone.models.Subreddit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubredditDetailsMapper {

	@Mapping(target="id", source = "subreddit.subredditId")
	@Mapping(target="topPosts", source = "subreddit.posts")
	@Mapping(target="numberOfPosts", expression = "java(subreddit.getPosts().size())")
	@Mapping(target = "createdAt", expression = "java(java.util.Date.from(subreddit.getCreatedDate()))")
	SubredditDetailsDto mapSubredditToSubredditDetailsDto(Subreddit subreddit);
}
