package com.example.redditclone.mappers;

import com.example.redditclone.dtos.PostRequest;
import com.example.redditclone.dtos.PostResponse;
import com.example.redditclone.models.Post;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T11:17:14+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post mapPostRequestToPost(PostRequest postRequest) {
        if ( postRequest == null ) {
            return null;
        }

        Post post = new Post();

        post.setDescription( postRequest.getDescription() );
        post.setUrl( postRequest.getUrl() );

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

        return postResponse;
    }
}
