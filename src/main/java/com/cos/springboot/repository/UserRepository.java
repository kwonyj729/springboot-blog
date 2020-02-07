package com.cos.springboot.repository;

import com.cos.springboot.model.user.User;
import com.cos.springboot.model.user.dto.ReqJoinDto;
import com.cos.springboot.model.user.dto.ReqLoginDto;

public interface UserRepository {
	
	int save(ReqJoinDto dto);
	int findByUsername(String username);  // 회원가입 단계에서, 유저네임 중복확인 할때 시용한다.
	
	
	// 로그인
	User findByUsernameAndPassword(ReqLoginDto reqLoginDto);
	
	
	
}
