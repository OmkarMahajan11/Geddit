package com.example.redditclone.mappers;

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
}
