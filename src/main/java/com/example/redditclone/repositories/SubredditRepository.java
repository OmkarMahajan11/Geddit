package com.example.redditclone.repositories;

import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubredditRepository extends JpaRepository<Subreddit, Long> {
	List<Subreddit> findAllByCreator(User creator);

	Subreddit findBySubredditId(Long id);
}
