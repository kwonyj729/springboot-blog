package com.cos.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PostController {
	
	@GetMapping({"", "/", "/post"})
	public String posts() {      //여기는 뷰리졀브가 관여해야함.
		return "/post/list";		
	}
	
	@GetMapping("/post/{id}")
	public String post() {
		return "/post/detail";
		
	}
	
	@GetMapping("/post/write")
	public String write() {
		return "/post/write";
		
	}
	
	
	@GetMapping("/post/update/{id}")
	public String update() {
		return "/post/update";
		
	}
	
	
	

}
