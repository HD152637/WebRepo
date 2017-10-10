$(document).ready(function() {
		$('#loginForm').submit(function(event) {
			event.preventDefault();
	
			var id = $('#loginId').val();
			var pwd = $('#loginPwd').val();
			
			$.post("/WebClass/bloglogin", {
				"loginId" : id,
				"loginPwd" : pwd
			},function(data){
				if(data){
					window.location.href="/WebClass/myblog/index.jsp";
				}
				else{
					var myModal = $('#loginModal');
					myModal.find('.modal-title').text('Sign In Error');
					myModal.find('.modal-body').text('로그인 시 오류가 발생하였습니다.');
					myModal.modal();
				}
			});
		});
	});

$(function() {
    $('#signForm').submit(function(event) {
        event.preventDefault();

        var id = $('#signId').val();
        var pwd = $('#signPwd').val();
        var cpwd = $('#confirmPwd').val();
        // console.log(id, pwd, cpwd);

        if (pwd == cpwd) {
            $.post("http://httpbin.org/post", {
                "id": id,
                "pwd": pwd
            }, function(data) {
                var myModal = $('#signModal');
                myModal.modal();
                myModal.find('.modal-body').text(data.form.id + '님 회원가입 되었습니다.');
            });
            document.getElementById("confirm").innerHTML = "";
        } else {
            document.getElementById("confirm").innerHTML = "비밀번호가 일치하지 않습니다.";
        }
    });
});