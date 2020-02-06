package com.cos.springboot.model;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String profile;
	private Timestamp createDate;
	
	@Builder
	public User(int id, String username, String password, String email, String profile, Timestamp createDate) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.profile = profile;
		this.createDate = createDate;
	}
}

