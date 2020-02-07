package com.cos.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.springboot.model.user.User;

// release 가지 연습용

@Controller
public class PostController {
	
	//인증체크해야함.
	@Autowired
	private HttpSession session;
	
	
	
	@GetMapping({"", "/", "/post"})
	public String posts() {      //여기는 뷰리졀브가 관여해야함.
		return "/post/list";		
	}
	
	@GetMapping("/post/{id}")
	public String post() {
		return "/post/detail";
		
	}
	
	
	// 인증 체크가 필요함.
	@GetMapping("/post/write")
	public String write() {
		
		
//		if(session.getAttribute("principal") != null) {
//			return "/post/write"; 
//		} else {
//			return "redirect:/user/login";
//			
//		}
		return "/post/write";
	}
	
	// 인증 체크가 필요함. (권한말고)동일인 인지 체크하기.!!
	@GetMapping("/post/update/{postId}")
	public String update(@PathVariable int postId, @RequestParam int userId) {
		
		User principal = (User)session.getAttribute("principal");
		if(principal.getId() == userId) {
		
			return "/user/login";
		}
		return "/post/update";
		// postId로 select 해서 post 가져오기 필요함.- Model에 담기 필요함.
	}
	
	
	

}
