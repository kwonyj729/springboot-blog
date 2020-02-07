package com.cos.springboot.model.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ReqJoinDto {
	
	
     @Size(max=15, message="유저네임 길이 이상함.")	
	 @NotBlank(message="유저네임 입력하세요.")
     @Pattern(regexp="^[a-zA-Z0-9]*$", message="유저네임은 영문 및 숫자만 가능합니다.")
	 private String username;
	 
     
	 @Size(max=15, message="패스워드 길이 이상함.")
	 @NotBlank(message="패스워드 입력하세요.")
	 private String password;
	 
	 
	 @Size(max=30, message="이메일 길이 이상함.")
	 @Email(message="이메일양식이 아님.")
	 @NotBlank(message="이메일 입력하세요.")
	 private String email;
	 
	 
	 
	public ReqJoinDto() {
		System.out.println("ReqJoinDto : ReqJoinDto()  호출됨");
	}

	public ReqJoinDto(String username, String password, String email) {
		System.out.println("ReqJoinDto : ReqJoinDto(All)  호출됨");
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("ReqJoinDto : setUsername() 호출됨");
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	 
}
