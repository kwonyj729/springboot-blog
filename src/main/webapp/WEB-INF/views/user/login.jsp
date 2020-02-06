<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">

	<form>

		<div class="form-group">
			<label for="username">유저네임 : </label> <input type="text" class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="password">패스워드 : </label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<!-- 필드 두개 받아서, 자바스크립트로 받아서 두개의 칸이 일치하는지 확인하기!! -->

	</form>

	<button id="login--submit" class="btn btn-primary">로그인</button>


</div>


<%@ include file="../include/footer.jsp"%>