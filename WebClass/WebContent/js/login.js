$(function() {
    $('#loginForm').submit(function(event) {
        event.preventDefault();

        var id = $('#loginId').val();
        var pwd = $('#loginPwd').val();
        // console.log(id, pwd);

        $.post("http://httpbin.org/post", {
            "id": id,
            "pwd": pwd
        }, function(data) {
            var myModal = $('#loginModal');
            myModal.modal();
            myModal.find('.modal-body').text(data.form.id + '님 로그인 되었습니다.');
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
            document.getElementById("confirm").innerHTML = ""
        } else {
            document.getElementById("confirm").innerHTML = "비밀번호가 일치하지 않습니다.";
        }
    });
});