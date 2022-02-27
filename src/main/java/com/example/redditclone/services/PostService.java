package com.example.redditclone.services;

import com.example.redditclone.dtos.PostRequest;
import com.example.redditclone.dtos.PostResponse;
import com.example.redditclone.exceptions.PostNotFoundException;
import com.example.redditclone.exceptions.SubredditNotFoundException;
import com.example.redditclone.exceptions.UserNotFoundException;
import com.example.redditclone.mappers.PostMapper;
import com.example.redditclone.models.Post;
import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import com.example.redditclone.repositories.PostRepository;
import com.example.redditclone.repositories.SubredditRepository;
import com.example.redditclone.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

	private final SubredditRepository subredditRepository;
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	private final AuthService authService;
	private final PostMapper postMapper;

	@Transactional
	public void save(PostRequest postRequest) {
		User user = authService.getCurrentUser();
		Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
			.orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));

		Post post = postMapper.mapPostRequestToPost(postRequest, subreddit, user);
		postRepository.save(post);
	}

	@Transactional
	public List<com.example.redditclone.dtos.PostResponse> getAllPosts() {
		return postRepository.findAll().stream()
			.map(postMapper::mapPostToPostResponse)
			.collect(Collectors.toList());
	}

	@Transactional
	public PostResponse getPost(Long id) {
		Post post = postRepository.findById(id)
			.orElseThrow(() -> new PostNotFoundException("Post Id: " + id));

		return postMapper.mapPostToPostResponse(post);
	}

	@Transactional
	public List<PostResponse> getPostsBySubreddit(Long id) {
		Subreddit subreddit = subredditRepository.findBySubredditId(id)
			.orElseThrow(() -> new SubredditNotFoundException("Subreddit Id: " + id));

		List<Post> posts = postRepository.findAllBySubreddit(subreddit);
		return posts.stream()
			.map(postMapper::mapPostToPostResponse)
			.collect(Collectors.toList());
	}

	@Transactional
	public List<PostResponse> getPostsByUsername(String username) {
		User user = userRepository.findByUsername(username)
			.orElseThrow(() -> new UserNotFoundException("Username: " + username));

		List<Post> posts = postRepository.findAllByAuthor(user);
		return posts.stream()
			.map(postMapper::mapPostToPostResponse)
			.collect(Collectors.toList());
	}
}
