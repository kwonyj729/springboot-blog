<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<!-- 여기에  3개 위치시키키 : 모든 코드가 다 업로드된 다음에 자바스크립트 코드가 나와야하니까 여기다가 둔다. 근데, 내 스크립트 코드가 먹힐려면 위에다가 둔다.!! 위치 이동됨.-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<!-- Brand -->
		<a class="navbar-brand" href="/">스프링 블로그 제작</a>

		<!-- Toggler/collapsibe Button -->
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!-- Navbar links -->
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">

				<c:choose>
					<c:when test="${not empty sessionScope.principal}">
						<!-- 밑에 둘다 GET 방식.  우리는 Proc를 쓸거임   ( GET이랑  POST 방식으로 바꺼도 된다.)-->
						<li class="nav-item"><a class="nav-link" href="/post/write">글쓰기</a></li>

						<li class="nav-item"><a class="nav-link" href="/user/profile/${sessionScope.principal.id}">회원정보수정</a></li>

						<li class="nav-item"><a class="nav-link" href="/user/logout">로그아웃</a></li>

					</c:when>
					<c:otherwise>
						<!-- 밑에 둘다 GET 방식.  우리는 Proc를 쓸거임   ( GET이랑  POST 방식으로 바꺼도 된다.)-->
						<li class="nav-item"><a class="nav-link" href="/user/join">회원가입</a></li>

						<li class="nav-item"><a class="nav-link" href="/user/login">로그인</a></li>

					</c:otherwise>


				</c:choose>




			</ul>
		</div>
	</nav>
	<br />