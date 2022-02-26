package com.example.redditclone.mappers;

import com.example.redditclone.dtos.SubredditDetailsDto;
import com.example.redditclone.models.Post;
import com.example.redditclone.models.Subreddit;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T00:01:23+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class SubredditDetailsMapperImpl implements SubredditDetailsMapper {

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
