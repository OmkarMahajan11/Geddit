package com.example.redditclone.mappers;

import com.example.redditclone.dtos.PostResponse;
import com.example.redditclone.dtos.SubredditDetailsDto;
import com.example.redditclone.dtos.SubredditDto;
import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubredditMapper {

	@Mapping(target="id", source = "subreddit.subredditId")
	SubredditDto mapSubredditToDto(Subreddit subreddit);

	@InheritInverseConfiguration
	@Mapping(target="createdDate", expression = "java(java.time.Instant.now())")
	@Mapping(target = "creator", source = "creator")
	Subreddit mapDtoToSubreddit(SubredditDto subredditDto, User creator);

	@Mapping(target="id", source = "subreddit.subredditId")
	@Mapping(target="topPosts", source = "posts")
	@Mapping(target="numberOfPosts", expression = "java(posts.size())")
	@Mapping(target = "createdAt", expression = "java(java.util.Date.from(subreddit.getCreatedDate()))")
	@Mapping(target = "createdBy", source = "creator.username")
	SubredditDetailsDto mapSubredditToSubredditDetailsDto(Subreddit subreddit, List<PostResponse> posts, User creator);
}
