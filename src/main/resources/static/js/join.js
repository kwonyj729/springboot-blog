/**
 * 회원가입 로직
 */

$('#join--submit').on('click', function() {

	let data = {
		username : $('#username').val(),
		password : $('#password').val(),
		email : $('#email').val()
	};

	$.ajax({
		type : 'POST',
		url : '/user/join',
		data : JSON.stringify(data),
		contentType : 'application/json; charset=utf-8',
		dataType : 'json'

	}).done(function(res) {
		if (res.statusCode == 200) {
			alert('회원가입 성공');
			location.href = '/user/login';
		} else {

			if (res.msg == '아이디중복') {
				alert('아이디 중복');

			}
			alert('회원가입 실패');
		}

	}).fail(function(res) {
		alert('회원가입 실패');

	});

});