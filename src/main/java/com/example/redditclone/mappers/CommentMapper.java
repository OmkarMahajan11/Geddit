package com.example.redditclone.mappers;

import com.example.redditclone.dtos.CommentDto;
import com.example.redditclone.models.Comment;
import com.example.redditclone.models.Post;
import com.example.redditclone.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

	@Mapping(target = "commentId", ignore = true)
	@Mapping(target = "createdAt", expression="java(java.time.Instant.now())")
	@Mapping(target = "author", source = "author")
	Comment mapCommentDtoToComment(CommentDto commentDto, Post post, User author);

	@Mapping(target = "id", source = "comment.commentId")
	@Mapping(target = "createdDate", source = "comment.createdAt")
	@Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
	@Mapping(target = "authorName", expression = "java(comment.getAuthor().getUsername())")
	CommentDto mapCommentToCommentDto(Comment comment);
}
