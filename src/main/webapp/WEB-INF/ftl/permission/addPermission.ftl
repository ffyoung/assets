<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>权限添加</title>

    <!-- Bootstrap -->
    <link href="/common/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/common/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/common/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="/common/animate.css/animate.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/css/common/green.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="/css/custom/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- sidebar menu -->
        <@_left.left />
        <!-- top navigation -->
         <@_top.top />
        <!-- page content -->
        <div class="right_col" role="main">
        <#--正文-->
        <#--vvvvvv以下为修改内容vvvvvv-->
            <div class="page-title">
                <div class="title_left">
                    <h3>权限信息添加</small></h3>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>


            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>权限添加
                                <small>^_^</small>
                            </h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <br/>
                            <form id="permissionform" data-parsley-validate class="form-horizontal form-label-left">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">权限名称 <span
                                            class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="name" name="name" required="required"
                                               class="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">权限资源 <span
                                            class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="url" name="url" required="required"
                                               class="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>
                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <button type="button" id="sub" class="btn btn-success">确认</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        <#--^^^^^^^^^^^^^^^^^^^^^-->
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="/js/common/jquery/jquery1.8.3.min.js"></script>
<!-- Bootstrap -->
<script src="/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- bootstrap-progressbar -->
<script src="/common/bootstrap/dist/js/bootstrap-progressbar.min.js"></script>
<!-- FastClick -->
<script src="/js/common/dist/fastclick.js"></script>
<!-- NProgress -->
<script src="/common/nprogress/nprogress.js"></script>
<!-- iCheck -->
<script src="/js/common/dist/icheck.min.js"></script>

<!-- DateJS -->
<script src="/js/common/dist/date.js"></script>

<!-- Custom Theme Scripts -->
<script src="/js/common/dist/custom.min.js"></script>

<script src="/js/common/layer/layer.js"></script>
<script src="/js/common/jquery-form.js"></script>

<script>
    jQuery(document).ready(
            /*提交信息*/
            $("#sub").click(function () {
                var form = $("#permissionform");
                var inputs = $("form :text");
                var inlength = inputs.length;
                for (var i = 0; i < inlength; i++) {
                    var self = $(inputs[i]);
                    if (self.val() == '') {
                        //保证传入后台的数据准确性，信息不为空
                        return layer.msg("请检查信息不能为空", function () {
                        }), !1;
                    }
                }
                var load = layer.load();
                $.post("/permission/addPermission", $("#permissionform").serialize(), function (result) {
                    layer.close(load);
                    if (result && result.status != 200) {
                        return layer.msg(result.message, function () {
                        }), !1;
                    } else {
                        layer.msg('添加成功!');
                        setTimeout(function () {
                            window.location.href = "/permission/all?pageNow=1";
                        }, 2000);
                    }
                }, "json");
            })
    )
</script>
</body>
</html>
