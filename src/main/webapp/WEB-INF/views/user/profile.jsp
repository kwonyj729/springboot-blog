<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">

	<form form="/user/profile" method="POST" encType="multipart/form-data">

		<div class="form-group">
			<label for="username">유저네임 : </label> <input type="text" class="form-control" placeholder="Enter username" name="username" value="${sessionScope.principal.username}" readonly="readonly" />
		</div>
		<div class="form-group">
			<label for="password">패스워드 : </label> 
			<input type="password" class="form-control" placeholder="Enter password" name="password" value="" />
		</div>
		<!-- 필드 두개 받아서, 자바스크립트로 받아서 두개의 칸이 일치하는지 확인하기!! -->
		
		<div class="form-group">
			<label for="email">이메일 : </label>      
			<input type="email" class="form-control" placeholder="Enter email" name="email" value="${sessionScope.principal.email}" readonly="readonly" />
		</div>
		
		<div class="form-group">
			<label for="profile">프로필 사진 : </label>      
			<input type="file" class="form-control" name="email" value="${sessionScope.principal.profile}" />
		</div>
		
		<button class="btn btn-primary">수정</button>

	</form>

	


</div>


<%@ include file="../include/footer.jsp"%>