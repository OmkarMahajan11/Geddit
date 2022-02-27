package com.example.redditclone.mappers;

import com.example.redditclone.dtos.SubredditDetailsDto;
import com.example.redditclone.dtos.SubredditDto;
import com.example.redditclone.models.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubredditMapper {

	@Mapping(target="id", source = "subreddit.subredditId")
	SubredditDto mapSubredditToDto(Subreddit subreddit);

	@InheritInverseConfiguration
	@Mapping(target="createdDate", expression = "java(java.time.Instant.now())")
	Subreddit mapDtoToSubreddit(SubredditDto subredditDto);

	@Mapping(target="id", source = "subreddit.subredditId")
	@Mapping(target="topPosts", source = "subreddit.posts")
	@Mapping(target="numberOfPosts", expression = "java(subreddit.getPosts().size())")
	@Mapping(target = "createdAt", expression = "java(java.util.Date.from(subreddit.getCreatedDate()))")
	SubredditDetailsDto mapSubredditToSubredditDetailsDto(Subreddit subreddit);
}
