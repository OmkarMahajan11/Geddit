package com.example.redditclone.mappers;

import com.example.redditclone.dtos.SubredditDetailsDto;
import com.example.redditclone.dtos.SubredditDto;
import com.example.redditclone.models.Post;
import com.example.redditclone.models.Subreddit;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T00:07:17+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
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
        subredditDto.setName( subreddit.getName() );
        subredditDto.setDescription( subreddit.getDescription() );
        subredditDto.setThumbnailPicture( subreddit.getThumbnailPicture() );

        return subredditDto;
    }

    @Override
    public Subreddit mapDtoToSubreddit(SubredditDto subredditDto) {
        if ( subredditDto == null ) {
            return null;
        }

        Subreddit subreddit = new Subreddit();

        if ( subredditDto.getId() != null ) {
            subreddit.setSubredditId( subredditDto.getId() );
        }
        subreddit.setName( subredditDto.getName() );
        subreddit.setDescription( subredditDto.getDescription() );
        subreddit.setThumbnailPicture( subredditDto.getThumbnailPicture() );

        subreddit.setCreatedDate( java.time.Instant.now() );

        return subreddit;
    }

    @Override
    public SubredditDetailsDto mapSubredditToSubredditDetailsDto(Subreddit subreddit) {
        if ( subreddit == null ) {
            return null;
        }

        SubredditDetailsDto subredditDetailsDto = new SubredditDetailsDto();

        subredditDetailsDto.setId( subreddit.getSubredditId() );
        List<Post> list = subreddit.getPosts();
        if ( list != null ) {
            subredditDetailsDto.setTopPosts( new ArrayList<Post>( list ) );
        }
        subredditDetailsDto.setName( subreddit.getName() );
        subredditDetailsDto.setDescription( subreddit.getDescription() );
        subredditDetailsDto.setThumbnailPicture( subreddit.getThumbnailPicture() );
        subredditDetailsDto.setPicture( subreddit.getPicture() );

        subredditDetailsDto.setNumberOfPosts( subreddit.getPosts().size() );
        subredditDetailsDto.setCreatedAt( java.util.Date.from(subreddit.getCreatedDate()) );

        return subredditDetailsDto;
    }
}
