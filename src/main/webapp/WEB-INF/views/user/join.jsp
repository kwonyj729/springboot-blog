<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">

	<form>

		<div class="form-group">
			<label for="username">유저네임 : </label> 
			<input type="text" class="form-control" placeholder="Enter username" id="username" maxlength="15">
		</div>
		<div class="form-group">
			<label for="password">패스워드 : </label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password" maxlength="15">
		</div>  <!-- 필드 두개 받아서, 자바스크립트로 받아서 두개의 칸이 일치하는지 확인하기!! -->
		<div class="form-group">
			<label for="email">이메일 : </label>      
			<input type="email" class="form-control" placeholder="Enter email" id="email" maxlength="30">
		</div>
		<!-- Remember me 는 쿠키사용인데, JSP 에서 헀기때문에 생략함. 이메일 인증 넣기 -->
	</form>
	
	<button id="join--submit" class="btn btn-primary">회원가입</button>

</div>

<script src="/js/join.js"></script>

<%@ include file="../include/footer.jsp"%>