<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>资产导入</title>

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

    <!-- bootstrap-daterangepicker -->
    <link href="/css/common/daterangepicker.css" rel="stylesheet">
    <script type="text/javascript">

        /*  ajax 方式上传文件操作 */
        $(document).ready(function () {
            $("#btn").click(function () {
                if (checkData()) {
                    $('#form1').ajaxSubmit({
                        url: 'uploadExcel/ajax',
                        dataType: 'text',
                        success: resutlMsg,
                        error: errorMsg
                    });

                    function resutlMsg(msg) {
                        alert(msg);
                        $("#upfile").val("");
                    }

                    function errorMsg() {
                        alert("导入excel出错！");
                    }
                }
            });
        });

        //JS校验form表单信息
        function checkData() {
            var fileDir = $("#upfile").val();
            var suffix = fileDir.substr(fileDir.lastIndexOf("."));
            if ("" == fileDir) {
                alert("选择需要导入的Excel文件！");
                return false;
            }
            if (".xls" != suffix && ".xlsx" != suffix) {
                alert("选择Excel格式的文件导入！");
                return false;
            }
            return true;
        }
    </script>
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
                    <h3>资产导入</small></h3>
                    <div>
                        <form method="POST" enctype="multipart/form-data" id="form1" action="/asset/import">

                            <label>上传文件: </label>
                            <input id="upfile" type="file" name="upfile"><br> <br>

                            <input type="submit" value="上传提交" onclick="return checkData()">
                        <#--<input type="button" value="ajax提交" id="btn" name="btn" >-->

                        </form>
                    </div>
                </div>
                <div id="complete"></div>
            </div>
        <#--^^^^^^^^^^^^^^^^^^^^^-->
        </div>
    </div>

    <!-- jQuery -->
    <script src="/js/common/jquery/jquery1.8.3.min.js"></script>
    <script src="/js/common/jquery/jquery.form-2.82.js"></script>
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
    <script src="/js/common/page/pageDo.js"></script>

    <!-- bootstrap-daterangepicker -->
    <script src="/js/common/dist/moment.min.js"></script>
    <script src="/js/common/dist/daterangepicker.js"></script>
</body>
</html>
