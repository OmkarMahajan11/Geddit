package com.example.redditclone.services;

import com.example.redditclone.dtos.SubredditDto;
import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import com.example.redditclone.repositories.SubredditRepository;
import com.example.redditclone.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubredditService {

	private final SubredditRepository subredditRepository;
	private final UserRepository userRepository;

	@Transactional
	public SubredditDto save(SubredditDto subredditDto) {
		Subreddit subreddit = new Subreddit();
		subreddit.setName(subredditDto.getName());
		subreddit.setDescription(subredditDto.getDescription());
		subreddit.setCreatedDate(Instant.now());

		User creator = userRepository.findByUsername(
			SecurityContextHolder.getContext()
				.getAuthentication().getName()
		).orElseThrow();

		subreddit.setCreator(creator);
		subredditRepository.save(subreddit);

		subredditDto.setId(subreddit.getSubredditId());
		return subredditDto;
	}
}
