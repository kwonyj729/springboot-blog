package com.cos.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.springboot.model.RespCode;
import com.cos.springboot.model.user.dto.ReqJoinDto;
import com.cos.springboot.repository.UserRepository;

@Service      //IoC 해준다.
public class UserService {
	
	@Autowired       //DI 해준다.
	private UserRepository userRepository;
			
	// result = 0 비정상, 1정상, -1 DB 오류, -2 아이디 중복
	@Transactional
	public int 회원가입(ReqJoinDto dto) {
		try {
			int result = userRepository.findByUsername(dto.getUsername());
			
			
			if(result == 1) {
				return RespCode.아이디중복;				
			
			} else {
				return userRepository.save(dto);
				
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
