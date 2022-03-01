package com.example.redditclone.mappers;

import com.example.redditclone.dtos.CommentDto;
import com.example.redditclone.models.Comment;
import com.example.redditclone.models.Post;
import com.example.redditclone.models.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-01T19:33:45+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment mapCommentDtoToComment(CommentDto commentDto, Post post, User author) {
        if ( commentDto == null && post == null && author == null ) {
            return null;
        }

        Comment comment = new Comment();

        if ( commentDto != null ) {
            comment.setText( commentDto.getText() );
        }
        if ( post != null ) {
            comment.setVoteCount( post.getVoteCount() );
        }
        if ( author != null ) {
            comment.setAuthor( author );
        }
        comment.setCreatedAt( java.time.Instant.now() );

        return comment;
    }

    @Override
    public CommentDto mapCommentToCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setId( comment.getCommentId() );
        commentDto.setCreatedDate( comment.getCreatedAt() );
        commentDto.setText( comment.getText() );

        commentDto.setPostId( comment.getPost().getPostId() );
        commentDto.setAuthorName( comment.getAuthor().getUsername() );

        return commentDto;
    }
}
