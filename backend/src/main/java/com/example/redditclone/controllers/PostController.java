package com.example.redditclone.controllers;

import com.example.redditclone.dtos.PostRequest;
import com.example.redditclone.dtos.PostResponse;
import com.example.redditclone.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@PostMapping
	public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
		postService.save(postRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<PostResponse>> getAllPosts() {
		return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(postService.getPost(id));
	}

	@GetMapping("by-subreddit/{id}")
	public ResponseEntity<List<PostResponse>> getPostsBySubreddit(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(postService.getPostsBySubreddit(id));
	}

	@GetMapping("by-user/{name}")
	public ResponseEntity<List<PostResponse>> getPostsByUsername(@PathVariable String name) {
		return ResponseEntity.status(HttpStatus.OK).body(postService.getPostsByUsername(name));
	}
}
