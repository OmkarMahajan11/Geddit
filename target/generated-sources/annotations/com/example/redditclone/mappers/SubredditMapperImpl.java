package com.example.redditclone.mappers;

import com.example.redditclone.dtos.PostResponse;
import com.example.redditclone.dtos.SubredditDetailsDto;
import com.example.redditclone.dtos.SubredditDto;
import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-12T00:40:55+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class SubredditMapperImpl implements SubredditMapper {

    @Override
    public SubredditDto mapSubredditToDto(Subreddit subreddit) {
        if ( subreddit == null ) {
            return null;
        }

        SubredditDto subredditDto = new SubredditDto();

        subredditDto.setId( subreddit.getSubredditId() );
        subredditDto.setDescription( subreddit.getDescription() );
        subredditDto.setName( subreddit.getName() );
        subredditDto.setThumbnailPicture( subreddit.getThumbnailPicture() );

        return subredditDto;
    }

    @Override
    public Subreddit mapDtoToSubreddit(SubredditDto subredditDto, User creator) {
        if ( subredditDto == null && creator == null ) {
            return null;
        }

        Subreddit subreddit = new Subreddit();

        if ( subredditDto != null ) {
            subreddit.setDescription( subredditDto.getDescription() );
            subreddit.setName( subredditDto.getName() );
            subreddit.setThumbnailPicture( subredditDto.getThumbnailPicture() );
        }
        if ( creator != null ) {
            subreddit.setCreator( creator );
        }
        subreddit.setCreatedDate( java.time.Instant.now() );

        return subreddit;
    }

    @Override
    public SubredditDetailsDto mapSubredditToSubredditDetailsDto(Subreddit subreddit, List<PostResponse> posts, User creator) {
        if ( subreddit == null && posts == null && creator == null ) {
            return null;
        }

        SubredditDetailsDto subredditDetailsDto = new SubredditDetailsDto();

        if ( subreddit != null ) {
            subredditDetailsDto.setId( subreddit.getSubredditId() );
            subredditDetailsDto.setDescription( subreddit.getDescription() );
            subredditDetailsDto.setName( subreddit.getName() );
            subredditDetailsDto.setPicture( subreddit.getPicture() );
            subredditDetailsDto.setThumbnailPicture( subreddit.getThumbnailPicture() );
        }
        if ( posts != null ) {
            List<PostResponse> list = posts;
            if ( list != null ) {
                subredditDetailsDto.setTopPosts( new ArrayList<PostResponse>( list ) );
            }
        }
        if ( creator != null ) {
            subredditDetailsDto.setCreatedBy( creator.getUsername() );
        }
        subredditDetailsDto.setNumberOfPosts( posts.size() );
        subredditDetailsDto.setCreatedAt( java.util.Date.from(subreddit.getCreatedDate()) );

        return subredditDetailsDto;
    }
}
