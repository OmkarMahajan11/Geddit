package com.example.redditclone.repositories;

import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubredditRepository extends JpaRepository<Subreddit, Long> {
	Optional<List<Subreddit>> findAllByCreator(User creator);

	Optional<Subreddit> findBySubredditId(Long id);

	Optional<Subreddit> findByName(String subredditName);
}
