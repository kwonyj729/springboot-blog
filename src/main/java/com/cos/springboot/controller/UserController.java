package com.cos.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cos.springboot.model.RespCM;
import com.cos.springboot.model.RespCode;
import com.cos.springboot.model.user.dto.ReqJoinDto;
import com.cos.springboot.service.UserService;

@Controller
public class UserController {
	
	private static final String TAG = "UserController";

	
	@Autowired
	private UserService UserService;
	
	
	@GetMapping("/user/join")
	public String join() {
		return "/user/join";
		
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
		
	}
	
	@GetMapping("/user/profile/{id}")
	public String profile() {
		return "/user/profile";
		
	}
	
	//메세지 컨버터(잭슨맵퍼)는 request 받을때, 생성자가 아니라 setter로(그리고 빈생성자) 호출한다.
	@PostMapping("/user/join")
	public ResponseEntity<?> join(@Valid @RequestBody ReqJoinDto dto, BindingResult bindingResult) {		
//		System.out.println(TAG+":" + dto.getUsername());
//		System.out.println(TAG+":" + dto.getPassword());
//		System.out.println(TAG+":" + dto.getEmail());
		
		//이거는  복붙하면 된다.
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error:bindingResult.getFieldErrors()) {	
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
		}// 여기까지 복붙.
		
		
		
		int result = UserService.회원가입(dto);
		
		
		if(result == -2) {
			return new ResponseEntity<RespCM>(new RespCM(RespCode.아이디중복, "아이디중복"), HttpStatus.OK);
		} else if(result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		} else {
			return new ResponseEntity<RespCM>(new RespCM(500,"fail"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
				
	}
	

		
		
		
		

}
