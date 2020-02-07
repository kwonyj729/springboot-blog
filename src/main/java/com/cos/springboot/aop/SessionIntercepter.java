package com.cos.springboot.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 벡종원 = 어댑터 패턴
// @Controller, @Configuration, @Service, @Repository
// @ Component  (이건 다른데서 new 하기 싫을때 붙여준다)
public class SessionIntercepter extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			System.out.println("인증 안된 사용자입니다.");
			response.sendRedirect("/user/login");
			
			return false;
		} else {
			System.out.println("인증되었습니다.");
			return true;
		}
	}

}
