<#--登录-->
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <title>登录界面</title>
    <!-- CSS -->
    <link rel="stylesheet" href="/css/login/reset.css"/>
    <link rel="stylesheet" href="/css/login/supersized.css"/>
    <link rel="stylesheet" href="/css/login/style.css"/>
    <style>
        canvas {
            position: fixed;
            top: 0px;
            left: 0px;
        }
        body{
            background-image: url("/css/img/backgrounds/1.jpg");
            background-color: #333366;
        }
    </style>
</head>
<body id="body">
<script>
</script>
<div class="page-container">
    <h1>Login</h1>
    <form id="_form" action="/user/loginDo" method="post" autocomplete="off">
        <input type="text" name="username" id="username" class="username" id="username" placeholder="Account">
        <input type="password" name="password" class="password" id="password" placeholder="Password">
        <button type="button" id="login">login</button>
        <button type="button" id="register" class="register">Register</button>
        <div class="error"><span>+</span></div>
    </form>
</div>
<!-- Javascript -->
<script src="/js/common/jquery/jquery1.8.3.min.js"></script>
<script src="/js/common/layer/layer.js"></script>
<script src="/js/common/jquery-form.js"></script>
<script src="/js/common/iconfont.js"></script>
<script>

    jQuery(document).ready(function() {

        $("#username").focus();
        //回车事件绑定
        document.onkeydown = function (event) {
            var e = event || window.event || arguments.callee.caller.arguments[0];
            if (e && e.keyCode == 13) {
                $('#login').click();
            }
        };

        //登录操作
        $('#login').click(function () {

            var username = $('#username').val();
            var password = $('#password').val();
            var lenu = username.length;
            if (username == '' || (lenu < 3 || lenu > 8)) {
                $('.error').fadeOut('fast', function () {
                    $('.error').css('top', '27px').show();
                });
                $('.error').fadeIn('fast', function () {
                    $('.username').focus();
                });
                return false;
            }
            if (password == '') {
                $('.error').fadeOut('fast', function () {
                    $('.error').css('top', '96px').show();
                });
                $(this).find('.error').fadeIn('fast', function () {
                    $('.password').focus();
                });
                return false;
            }
            var pswd = password;
            data = {password: pswd, username: username};
            var load = layer.load();

            $.ajax({
                url: "/user/loginDo",
                data: data,
                type: "post",
                dataType: "json",
                beforeSend: function () {
                    layer.msg('正在登陆，请注意信息提示。');
                },
                success: function (result) {
                    console.log(result);
                    layer.close(load);
                    if (result && result.status != 200) {
                        layer.msg("账号密码错误！");
                        $('.password').val('');
                        return;
                    } else {
                        layer.msg('登录成功！');
                        setTimeout(function () {
                            //登录返回
                            window.location.href ="main";
                        }, 1000)
                    }
                },
                error: function (e) {
                    console.log(e, e.message);
                    layer.msg('请看后台Java控制台，是否报错', new Function());
                }
            });
        });
        $('.page-container form .username, .page-container form .password').keyup(function () {
            $(this).parent().find('.error').fadeOut('fast');
        });

    });


    //注册
    $("#register").click(function () {
        window.location.href = "register";
    });

</script>
</body>

</html>

