package com.example.redditclone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name ="subreddits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subreddit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subredditId;

	@NotBlank(message = "Community name is required")
	private String name;
	
	@NotBlank(message="Description is required")
	private String description;

	private Instant createdDate;

	@ManyToOne(fetch = FetchType.LAZY)
	private User creator;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> posts;

	@OneToMany(fetch = FetchType.LAZY)
	private List<User> subscribers;

	@OneToMany(fetch = FetchType.LAZY)
	private List<User> mods;
}
