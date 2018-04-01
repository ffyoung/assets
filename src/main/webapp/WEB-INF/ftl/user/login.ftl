<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Login Page|</title>

    <!-- Bootstrap -->
    <link href="/common/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/common/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/common/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="/common/animate.css/animate.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="/css/custom/custom.min.css" rel="stylesheet">
</head>

<body class="login" >
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form>
                    <h1>登 录</h1>
                    <div>
                        <input type="text" class="form-control" id="username" name="username" placeholder="账 号" autocomplete="off" />
                    </div>
                    <div>
                        <input type="password" class="form-control" id="password" name="password" placeholder="密 码" autocomplete="off"  />
                    </div>
                    <div>
                        <button class="btn btn-default submit" type="button" id="login">登 录</button>
                        <a class="reset_pass" href="#">忘 记 密 码 ?</a>
                    </div>
                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">新用户?
                            <a href="#signup" class="to_register"> 创 建 用 户 </a>
                        </p>
                        <div class="clearfix"></div>
                        <br />

                        <div>
                            <p>©2018 河南省乾元水资源开发利用有限公司</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>

        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form action="/user/registerDo" method="post">
                    <h1>新用户</h1>
                    <div>
                        <input type="text" class="form-control" placeholder="用 户 名" name="username" required="" />
                    </div>
                    <div>
                        <input type="email" class="form-control" placeholder="昵 称" name="nickname" required="" />
                    </div>
                    <div>
                        <input type="password" class="form-control" placeholder="密 码" name="password" required="" />
                    </div>

                    <div>
                        <input type="submit" value="提交"/>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">已经有账户?
                            <a href="#signin" class="to_register"> 登 录  </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                        <div>
                            <p>©2018 河南省乾元水资源开发利用有限公司</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
<!-- Javascript -->
<script src="/js/common/jquery/jquery1.8.3.min.js"></script>
<script src="/js/common/layer/layer.js"></script>
<script src="/js/common/jquery-form.js"></script>
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
            // if (username == '' || (lenu < 3 || lenu > 11)) {
            if (username == '') {
                layer.msg("账号不能为空/格式不正确对..")
                $('#username').focus();
                return false;
            }
            if (password == '') {
                layer.msg("密码不能为空")
                $('#password').focus();
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
                    console.log(result.msg);


                    layer.close(load);
                    if (result && result.status != 200) {
                        window.location.href ="main";
                        layer.msg("账号密码错误！");
                        $('#password').val('');
                        return;
                    } else {
                        window.location.href ="main";
                        layer.msg('登录成功！');
                        setTimeout(function () {
                            //登录返回

                        }, 1000)
                    }
                },
                error: function (e) {
                    layer.msg('请看后台Java控制台，是否报错', new Function());
                }
            });
        });
    });


    //注册
    // $("#register").click(function () {
    //     window.location.href = "register";
    // });

</script>
</body>
</html>
