<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>角色列表</title>


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
                    <h3>角色列表</small></h3>
                    <div style="position: absolute;right: 1cm;">
                        <a href="/role/addRoleIndex" class="btn btn-default">新增角色</a>
                    </div>
                    <hr/>
                    <form id="formId" method="post" action="/role/all" autocomplete="off">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group  top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="输入角色名称/类型" name="content"
                                       value="${content?default('')}" id="content"/>
                                <span class="input-group-btn">
                                    <input class="btn btn-default" type="submit" value="查询"/>
                                </span>
                            </div>
                        </div>

                </div>
                <div>
                    <table class="table table-striped jambo_table bulk_action">
                        <tr>
                            <td>序号</td>
                            <td>角色名称</td>
                            <td>角色类型</td>
                            <td>操作</td>
                        </tr>
                        <#if rolelist?size gt 0>
                            <#list rolelist as list>
                        <tr>
                            <td>${(currentPage-1)*10+list_index+1}</td>
                            <td>${list.name}</td>
                            <td>${list.type}</td>
                            <td>
                                <a href="javascript:updateMsg(${list.id})" + class="btn btn-default">修改</a>
                                <a class="btn btn-default" href="javascript: deleteById(${list.id});">删除</a>
                            </td>
                        </tr>
                            </#list>
                        <#elseif !results>
                    <tr>
                        <td class="text-center danger" colspan="7">没有找到</td>
                    </tr>
                        </#if>
                    </table>
                    <div id="complete"></div>
                    </form>
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
<script src="/js/common/page/pageDo.js"></script>
<script>

    <#--分页-->
    $(function () {
        PagingManage($('#complete'),${totalPage}, 10, ${currentPage});
    });


    //分页跳转
    function pageDo(page){
        var wd = $("#content").val();
        var url = "/role/all?pageNow=" + page + "&content=" + wd;
        window.location.href = url;
    }


    /*更改信息页面跳转*/
    function updateMsg(id) {
        var url = "/role/updateDo/" + id;
        window.location.href = url;
    }


    /*删除操作*/
    function deleteById(id) {
        var load = layer.load();
        var url = "/role/delete/" + id;
        console.log(url);
        layer.confirm('确定删除此信息？', {
                    btn: ['是', '否'] //按钮
                }, function () {
                    layer.msg('正在删除..', function () {
                        $.ajax({
                            type: "post",
                            url: url,
                            success: function (result) {
                                layer.close(load);
                                if (result && result.status != 200) {
                                    layer.msg(result.message);
                                } else {
                                    layer.msg("操作成功", function () {
                                        window.location.reload();
                                    });
                                }
                            }
                        });
                    });
                }
                , function () {
                    layer.close(load);
                    layer.msg('请继续操作..');
                });
    }


</script>
</body>
</html>
