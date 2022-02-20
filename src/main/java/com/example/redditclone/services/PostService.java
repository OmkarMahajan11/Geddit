package com.example.redditclone.services;

import com.example.redditclone.dtos.PostRequest;
import com.example.redditclone.dtos.PostResponse;
import com.example.redditclone.exceptions.PostNotFoundException;
import com.example.redditclone.exceptions.SubredditNotFoundException;
import com.example.redditclone.exceptions.UserNotFoundException;
import com.example.redditclone.models.Post;
import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import com.example.redditclone.repositories.PostRepository;
import com.example.redditclone.repositories.SubredditRepository;
import com.example.redditclone.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

	private final SubredditRepository subredditRepository;
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	private final AuthService authService;

	@Transactional
	public void save(PostRequest postRequest) {
		Post post = new Post();

		post.setDescription(postRequest.getDescription());
		post.setUrl(postRequest.getUrl());
		post.setCreatedAt(Instant.now());
		post.setAuthor(authService.getCurrentUser());

		Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
			.orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));
		post.setSubreddit(subreddit);

		postRepository.save(post);
	}

	@Transactional
	public List<PostResponse> getAllPosts() {
		List<Post> allPosts = postRepository.findAll();
		List<PostResponse> result = new ArrayList<>();

		for (Post post : allPosts) {
			PostResponse pr = new PostResponse();
			pr.setDescription(post.getDescription());
			pr.setSubredditName(post.getSubreddit().getName());
			pr.setVoteCount(post.getVoteCount());
			pr.setUrl(post.getUrl());
			pr.setUserName("u/" + post.getAuthor().getUsername());
			result.add(pr);
		}

		return result;
	}

	@Transactional
	public PostResponse getPost(Long id) {
		Post post = postRepository.findById(id)
			.orElseThrow(() -> new PostNotFoundException("Post Id: " + id));

		PostResponse pr = new PostResponse();
		pr.setId(post.getPostId());
		pr.setDescription(post.getDescription());
		pr.setUrl(post.getUrl());
		pr.setVoteCount(post.getVoteCount());
		pr.setSubredditName(post.getSubreddit().getName());
		pr.setId(post.getPostId());
		pr.setUserName("u/" + post.getAuthor().getUsername());

		return pr;
	}

	@Transactional
	public List<PostResponse> getPostsBySubreddit(Long id) {
		Subreddit subreddit = subredditRepository.findBySubredditId(id)
			.orElseThrow(() -> new SubredditNotFoundException("Subreddit Id: " + id));

		List<Post> posts = postRepository.findAllBySubreddit(subreddit);

		List<PostResponse> result = new ArrayList<>();
		for (Post post : posts) {
			PostResponse pr = new PostResponse();
			pr.setId(post.getPostId());
			pr.setDescription(post.getDescription());
			pr.setSubredditName(post.getSubreddit().getName());
			pr.setVoteCount(post.getVoteCount());
			pr.setUrl(post.getUrl());
			pr.setUserName("u/" + post.getAuthor().getUsername());
			result.add(pr);
		}

		return result;
	}

	@Transactional
	public List<PostResponse> getPostsByUsername(String username) {
		User user = userRepository.findByUsername(username)
			.orElseThrow(() -> new UserNotFoundException("Username: " + username));

		List<Post> posts = postRepository.findAllByAuthor(user);

		List<PostResponse> result = new ArrayList<>();
		for (Post post : posts) {
			PostResponse pr = new PostResponse();
			pr.setId(post.getPostId());
			pr.setDescription(post.getDescription());
			pr.setSubredditName(post.getSubreddit().getName());
			pr.setVoteCount(post.getVoteCount());
			pr.setUrl(post.getUrl());
			pr.setUserName("u/" + post.getAuthor().getUsername());
			result.add(pr);
		}

		return result;
	}
}
