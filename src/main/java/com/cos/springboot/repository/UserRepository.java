package com.cos.springboot.repository;

import com.cos.springboot.model.user.dto.ReqJoinDto;

public interface UserRepository {
	
	int save(ReqJoinDto dto);
	
	// 회원가입 단계에서, 유저네임 중복확인 할때 시용한다.
	int findByUsername(String username);
	
	
	
}
