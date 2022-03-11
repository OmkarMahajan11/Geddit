package com.example.redditclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
	private Long id;
	private String url;
	private String description;
	private String authorName;
	private String subredditName;
	private int voteCount;
}
