package com.example.redditclone.services;

import com.example.redditclone.dtos.SubredditDetailsDto;
import com.example.redditclone.dtos.SubredditDto;
import com.example.redditclone.exceptions.SubredditNotFoundException;
import com.example.redditclone.mappers.SubredditDetailsMapper;
import com.example.redditclone.mappers.SubredditMapper;
import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import com.example.redditclone.repositories.SubredditRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubredditService {

	private final SubredditRepository subredditRepository;
	private final AuthService authorService;
	private final SubredditMapper subredditMapper;
	private final SubredditDetailsMapper subredditDetailsMapper;

	@Transactional
	public SubredditDto save(SubredditDto subredditDto) {
		Subreddit subreddit = subredditMapper.mapDtoToSubreddit(subredditDto);

		User creator = authorService.getCurrentUser();

		subreddit.setCreator(creator);
		subredditRepository.save(subreddit);

		subredditDto.setId(subreddit.getSubredditId());
		return subredditDto;
	}

	@Transactional
	public List<SubredditDto> getAll() {
		List<Subreddit> allSubs = subredditRepository.findAll();

		return allSubs.stream()
			.map(subredditMapper::mapSubredditToDto)
			.collect(Collectors.toList());
	}

	@Transactional
	public List<SubredditDto> getAllCreated() {
		User creator = authorService.getCurrentUser();

		List<Subreddit> allSubs = subredditRepository.findAllByCreator(creator)
			.orElseThrow(() -> new SubredditNotFoundException(""));

		return allSubs.stream()
			.map(subredditMapper::mapSubredditToDto)
			.collect(Collectors.toList());
	}

	@Transactional
	public SubredditDetailsDto getSubredditDetails(Long id) {
		Subreddit sub = subredditRepository.findBySubredditId(id)
			.orElseThrow(() -> new SubredditNotFoundException("Subreddit Id: " + id));

		SubredditDetailsDto subDetails = subredditDetailsMapper.mapSubredditToSubredditDetailsDto(sub);
		subDetails.setCreatedBy("u/" + sub.getCreator().getUsername());

		return subDetails;
	}
}
