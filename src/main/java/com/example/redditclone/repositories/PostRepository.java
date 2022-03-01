package com.example.redditclone.repositories;

import com.example.redditclone.models.Post;
import com.example.redditclone.models.Subreddit;
import com.example.redditclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findAllBySubreddit(Subreddit subreddit);

	List<Post> findAllByAuthor(User user);

	Optional<Post> findByPostId(long postId);
}
