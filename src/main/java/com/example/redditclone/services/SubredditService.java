package com.example.redditclone.services;

import com.example.redditclone.dtos.SubredditDetailsDto;
import com.example.redditclone.dtos.SubredditDto;
import com.example.redditclone.models.Post;
import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import com.example.redditclone.repositories.SubredditRepository;
import com.example.redditclone.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
		subreddit.setThumbnailPicture(subredditDto.getThumbnailPicture());
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

	@Transactional
	public List<SubredditDto> getAll() {
		List<Subreddit> allSubs = subredditRepository.findAll();

		List<SubredditDto> result = new ArrayList<>();
		for (Subreddit sub : allSubs) {
			SubredditDto s = new SubredditDto();
			s.setId(sub.getSubredditId());
			s.setName(sub.getName());
			s.setDescription(sub.getDescription());
			s.setThumbnailPicture(sub.getThumbnailPicture());
			result.add(s);
		}

		return result;
	}

	@Transactional
	public List<SubredditDto> getAllCreated() {
		User creator = userRepository.findByUsername(
			SecurityContextHolder.getContext()
				.getAuthentication().getName()
		).orElseThrow();

		List<Subreddit> allSubs = subredditRepository.findAllByCreator(creator);

		List<SubredditDto> result = new ArrayList<>();
		for (Subreddit sub : allSubs) {
			SubredditDto s = new SubredditDto();
			s.setId(sub.getSubredditId());
			s.setName(sub.getName());
			s.setDescription(sub.getDescription());
			s.setThumbnailPicture(sub.getThumbnailPicture());
			result.add(s);
		}

		return result;
	}

	@Transactional
	public SubredditDetailsDto getSubredditDetails(Long id) {
		Subreddit sub = subredditRepository.findBySubredditId(id);

		SubredditDetailsDto subDetails = new SubredditDetailsDto();
		subDetails.setId(sub.getSubredditId());
		subDetails.setName(sub.getName());
		subDetails.setDescription(sub.getDescription());
		subDetails.setThumbnailPicture(sub.getThumbnailPicture());
		subDetails.setPicture(sub.getPicture());
		subDetails.setCreatedAt(Date.from(sub.getCreatedDate()));

		List<Post> posts = sub.getPosts();
		subDetails.setNumberOfPosts(posts.size());
		subDetails.setTopPosts(posts);

		subDetails.setCreatedBy("u/" + sub.getCreator().getUsername());

		return subDetails;
	}
}
