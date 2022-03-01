package com.example.redditclone.services;

import com.example.redditclone.dtos.CommentDto;
import com.example.redditclone.exceptions.PostNotFoundException;
import com.example.redditclone.exceptions.UserNotFoundException;
import com.example.redditclone.mappers.CommentMapper;
import com.example.redditclone.models.Comment;
import com.example.redditclone.models.Post;
import com.example.redditclone.models.User;
import com.example.redditclone.repositories.CommentRepository;
import com.example.redditclone.repositories.PostRepository;
import com.example.redditclone.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

	private final PostRepository postRepository;
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final AuthService authService;
	private final CommentMapper commentMapper;

	public void save(CommentDto commentDto) {
		Post post = postRepository.findByPostId(commentDto.getPostId())
			.orElseThrow(() -> new PostNotFoundException("Post Id: " + commentDto.getPostId()));

		Comment comment = commentMapper.mapCommentDtoToComment(commentDto, post, authService.getCurrentUser());
		commentRepository.save(comment);
	}

	public List<CommentDto> getAllCommentsForPost(Long postId) {
		Post post = postRepository.findByPostId(postId)
			.orElseThrow(() -> new PostNotFoundException("Post Id: " + postId));

		return commentRepository.findByPost(post).stream()
			.map(commentMapper::mapCommentToCommentDto)
			.collect(Collectors.toList());
	}

	public List<CommentDto> getAllCommentsForUser(String username) {
		User author = userRepository.findByUsername(username)
			.orElseThrow(() -> new UserNotFoundException("Username: " + username));

		return commentRepository.findByAuthor(author).stream()
			.map(commentMapper::mapCommentToCommentDto)
			.collect(Collectors.toList());
	}
}
