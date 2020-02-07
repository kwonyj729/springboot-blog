package com.cos.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springboot.model.RespCM;
import com.cos.springboot.model.ReturnCode;
import com.cos.springboot.model.user.User;
import com.cos.springboot.model.user.dto.ReqJoinDto;
import com.cos.springboot.model.user.dto.ReqLoginDto;
import com.cos.springboot.service.UserService;

@Controller
public class UserController {

	private static final String TAG = "UserController";

	// DI 해주기.
	@Autowired
	private UserService userService;

	@Autowired // 세션은 모든 곳 여러군데에서 쓸 거기 때문에, 함수의 매개변수로 넣지말고 여기에 빼둔다..
	private HttpSession session;

	@GetMapping("/user/join")
	public String join() {
		return "/user/join";

	}

	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}

	// 인증 안해도됨.
	@GetMapping("/user/logout")
	public String logout() {
		session.invalidate();

		// return "/user/login";
		return "redirect:/";

	}

	// 인증체크와과 동일인 체크하기.!!
	@GetMapping("/user/profile/{id}")
	public String profile(@PathVariable int id) { // @ResponseBody 붙이면, viewResolver 가 관여할수 없게 막혀 있기 때문에, 페이지 이동 안됨. 데이터
													// 전송만 가능함.

		User principal = (User)session.getAttribute("principal");
		
		// 동일인 만 체크함. 아이디 비교하기.
		if (principal.getId() == id) {
			return "/user/profile";
		} else {
			// 잡못된 접근입니다.권한이 없습니다.(자바스크립트로 뜨게 만들어야함.)
			return "/user/login";
		}
	}

	// 메세지 컨버터(잭슨맵퍼)는 request 받을때, 생성자가 아니라 setter로(그리고 빈생성자) 호출한다.
	@PostMapping("/user/join")
	public ResponseEntity<?> join(@Valid @RequestBody ReqJoinDto dto, BindingResult bindingResult) {
//		System.out.println(TAG+":" + dto.getUsername());
//		System.out.println(TAG+":" + dto.getPassword());
//		System.out.println(TAG+":" + dto.getEmail());

		// 이거는 복붙하면 된다.
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();

			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		} // 여기까지 복붙.

		int result = userService.회원가입(dto);

		if (result == -2) {
			return new ResponseEntity<RespCM>(new RespCM(ReturnCode.아이디중복, "아이디중복"), HttpStatus.OK);
		} else if (result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		} else {
			return new ResponseEntity<RespCM>(new RespCM(500, "fail"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 로그인
	@PostMapping("/user/login")
	public ResponseEntity<?> login(@Valid @RequestBody ReqLoginDto reqLoginDto, BindingResult bindingResult) {

		// 서비스 호출
		User principal = userService.로그인(reqLoginDto);
		// principal : 접근된 인증주체이다.

		if (principal != null) {
			session.setAttribute("principal", principal);

			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);

		} else {
			return new ResponseEntity<RespCM>(new RespCM(400, "fail"), HttpStatus.BAD_REQUEST);
		}

	}

}
