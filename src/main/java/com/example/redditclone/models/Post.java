package com.example.redditclone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName="userId")
	private User author;

	@NotBlank(message="Description is required")
	private String description;

	private Instant createdAt;

	private int voteCount=0;

	@Nullable
	private String url;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subredditId", referencedColumnName = "subredditId")
	private Subreddit subreddit;
}
