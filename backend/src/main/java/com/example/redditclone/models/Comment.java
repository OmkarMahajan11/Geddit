package com.example.redditclone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private User author;

	private Instant createdAt;

	@NotBlank(message="Text required")
	private String text;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="postId", referencedColumnName = "postId")
	private Post post;

	private int voteCount=0;
}
