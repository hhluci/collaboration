$(document).ready(
    function () {

        $('input').iCheck({
            checkboxClass: 'icheckbox_minimal-green',
            radioClass: 'iradio_minimal-green',
            increaseArea: '20%'
        });

        var $formPanelTwo = $('.form-panel.two');

        var panelOne = $formPanelTwo.height();
        var panelTwo = $formPanelTwo[0].scrollHeight;

        $formPanelTwo.not('.form-panel.two.active').on('click', function (e) {
            e.preventDefault();

            $('.form-toggle').addClass('visible');
            $('.form-panel.one').addClass('hidden');
            $('.form-panel.two').addClass('active');
            $('.form').animate({
                'height': panelTwo
            }, 200);
        });

        $('.form-toggle').on('click', function (e) {
            e.preventDefault();
            $(this).removeClass('visible');
            $('.form-panel.one').removeClass('hidden');
            $('.form-panel.two').removeClass('active');
            $('.form').animate({
                'height': panelOne + 92
            }, 200);
        });


    }
);


function formLogin() {
    var $loginButton = $("#form-login-button");
    var username = $(".one input[name='username']").val().trim();
    var password = $(".one input[name='password']").val().trim();
    var $form = $(".one").find("form");
    if (username === "") {
        $MB.n_warning("请输入账号！");
        return;
    }
    if (password === "") {
        $MB.n_warning("请输入密码！");
        return;
    }

    $loginButton.html("").append("<div class='login-loder'><div class='line-scale'><div></div><div></div><div></div><div></div><div></div></div></div>");

    $.ajax({
        type: "post",
        url: "",
        data: $form.serialize(),
        dataType: "json",
        success: function (r) {
            if (r.msg === "") {
                if (confirm("您已经登录,是否要重新登录")) {
                    alert("用户已退出");
                    location.href = '/logout';
                } else {
                    location.href = '/index';
                }
            }
            $MB.n_warning(r.msg);
            $form[0].reset();
            $loginButton.html("登录");
        },
        error: function () {
            location.href = '/index';
        }

    });
}


function regist() {
    var username = $(".two input[name='username']").val().trim();
    var password = $(".two input[name='password']").val().trim();
    var cpassword = $(".two input[name='cpassword']").val().trim();
    var name = $(".two input[name='name']").val().trim();
    if (username === "") {
        $MB.n_warning("账号不能为空！");
        return;
    } else if (username.length > 10) {
        $MB.n_warning("账号长度不能超过10个字符！");
        return;
    } else if (username.length < 3) {
        $MB.n_warning("账号长度不能少于3个字符！");
        return;
    }
    if (name === "") {
        $MB.n_warning("昵称不能为空！");
        return;
    } else if (name.length > 10) {
        $MB.n_warning("昵称长度不能超过10个字符！");
        return;
    } else if (name.length < 2) {
        $MB.n_warning("昵称长度不能少于2个字符！");
        return;
    }

    if (password === "") {
        $MB.n_warning("密码不能为空！");
        return;
    }
    if (cpassword === "") {
        $MB.n_warning("请再次输入密码！");
        return;
    }
    if (cpassword !== password) {
        $MB.n_warning("两次密码输入不一致！");
        return;
    }
    $.ajax({
        type: "post",
        url: ctx + "sysuser/regist",
        data: {
            "username": username,
            "password": password,
            "name": name,
            "state": "0"
        },
        dataType: "json",
        success: function (r) {
            if (r.code === 0) {
                $MB.n_success("注册成功，请登录");
                $(".two input[name='username']").val("");
                $(".two input[name='password']").val("");
                $(".two input[name='cpassword']").val("");
                $(".two input[name='name']").val("");
                $('.form-toggle').trigger('click');
            } else {
                $MB.n_warning(r.msg);
            }
        }
    });
}
