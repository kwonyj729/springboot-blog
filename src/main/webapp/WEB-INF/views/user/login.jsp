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


<!-- 로그인을 생각했은때 select 인게 맞지만, 주소에 남아서 날아가므로, 결국 내용을 암호화 해야한다. 그래서 우리는 POST 방식으로 한다. -->
<script>

	$('#login--submit').on('click',function() {
		var data = {
			username:$('#username').val(),
			password:$('#password').val()
		}

		$.ajax({
			type:'POST',
			url:'/user/login',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
				
		}).done(function(res) {
			alert("로그인 성공");
			location.href='/';
				
		}).fail(function(res) {
			alert("로그인 실패");
			console.log(res);
		});
	});
</script>


<%@ include file="../include/footer.jsp"%>