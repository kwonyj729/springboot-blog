package com.cos.springboot.model.user.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqLoginDto {
	
	
     @Size(max=15, message="유저네임 길이 이상함.")	
	 @NotBlank(message="유저네임 입력하세요.")
     @Pattern(regexp="^[a-zA-Z0-9]*$", message="유저네임은 영문 및 숫자만 가능합니다.")
	 private String username;
	 
     
	 @Size(max=15, message="패스워드 길이 이상함.")
	 @NotBlank(message="패스워드 입력하세요.")
	 private String password;
	
	 // 이메일 삭제
	 
	  
}
