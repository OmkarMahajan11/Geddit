package com.example.redditclone.mappers;

import com.example.redditclone.dtos.PostRequest;
import com.example.redditclone.dtos.PostResponse;
import com.example.redditclone.models.Post;
import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-12T17:50:36+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post mapPostRequestToPost(PostRequest postRequest, Subreddit subreddit, User user) {
        if ( postRequest == null && subreddit == null && user == null ) {
            return null;
        }

        Post post = new Post();

        if ( postRequest != null ) {
            post.setDescription( postRequest.getDescription() );
            post.setUrl( postRequest.getUrl() );
        }
        if ( subreddit != null ) {
            post.setSubreddit( subreddit );
        }
        if ( user != null ) {
            post.setAuthor( user );
        }
        post.setCreatedAt( java.time.Instant.now() );

        return post;
    }

    @Override
    public PostResponse mapPostToPostResponse(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResponse postResponse = new PostResponse();

        postResponse.setId( post.getPostId() );
        postResponse.setDescription( post.getDescription() );
        postResponse.setUrl( post.getUrl() );
        postResponse.setVoteCount( post.getVoteCount() );

        postResponse.setSubredditName( post.getSubreddit().getName() );
        postResponse.setAuthorName( post.getAuthor().getUsername() );

        return postResponse;
    }
}
