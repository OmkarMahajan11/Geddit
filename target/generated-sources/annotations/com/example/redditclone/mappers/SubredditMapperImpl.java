package com.example.redditclone.mappers;

import com.example.redditclone.dtos.SubredditDto;
import com.example.redditclone.models.Subreddit;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-25T01:13:58+0530",
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
}
