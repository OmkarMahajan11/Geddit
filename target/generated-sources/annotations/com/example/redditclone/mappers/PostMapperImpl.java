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
    date = "2022-03-01T19:33:46+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
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
        postResponse.setUrl( post.getUrl() );
        postResponse.setDescription( post.getDescription() );
        postResponse.setVoteCount( post.getVoteCount() );

        postResponse.setSubredditName( post.getSubreddit().getName() );
        postResponse.setAuthorName( post.getAuthor().getUsername() );

        return postResponse;
    }
}
