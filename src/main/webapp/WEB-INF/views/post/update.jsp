<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">

	<form>

		<div class="form-group">
			<label for="title">제목 : </label> 
			<input type="text" class="form-control" placeholder="Enter title" id="title" value="제목입니다.EL">
		</div>
		<div class="form-group">
			<label for="content">내용 : </label> 
			<textarea class="form-control" rows="10" id="content">내용입니다. EL</textarea>
		</div>
    

	</form>

	<button id="update--submit" class="btn btn-warning">글수정</button>

<!-- 사진 파일 첨부 또는 썸머노트 활용하기 -->
</div>


<%@ include file="../include/footer.jsp"%>