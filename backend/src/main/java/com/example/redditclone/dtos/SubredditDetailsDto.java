package com.example.redditclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubredditDetailsDto {
	private Long id;
	private String name;
	private String description;
	private String thumbnailPicture;
	private String picture;
	private String createdBy;
	private int numberOfPosts;
	private Date createdAt;
	private List<PostResponse> topPosts;
}
