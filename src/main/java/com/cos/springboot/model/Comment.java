package com.cos.springboot.model;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Comment {
	
	private int id;
	private int userId;
	private int postId;
	private String content;
	private Timestamp createDate;
	
	@Builder
	public Comment(int id, int userId, int postId, String content, Timestamp createDate) {

		this.id = id;
		this.userId = userId;
		this.postId = postId;
		this.content = content;
		this.createDate = createDate;
	}
	
	

}
