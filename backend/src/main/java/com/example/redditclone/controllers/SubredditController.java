package com.example.redditclone.controllers;

import com.example.redditclone.dtos.SubredditDetailsDto;
import com.example.redditclone.dtos.SubredditDto;
import com.example.redditclone.services.SubredditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subreddits")
@RequiredArgsConstructor
@Slf4j
public class SubredditController {

	private final SubredditService subredditService;

	@PostMapping
	public ResponseEntity<SubredditDto> createSubreddit(@RequestBody SubredditDto subredditDto) {
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(subredditService.save(subredditDto));
	}

	@GetMapping
	public ResponseEntity<List<SubredditDto>> getAllSubreddits() {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(subredditService.getAll());
	}

	@GetMapping("/created")
	public ResponseEntity<List<SubredditDto>> getAllCreatedSubreddits() {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(subredditService.getAllCreated());
	}

	@GetMapping("/{id}")
	public ResponseEntity<SubredditDetailsDto> getSubredditDetails(@PathVariable("id") Long id) {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(subredditService.getSubredditDetails(id));
	}
}
