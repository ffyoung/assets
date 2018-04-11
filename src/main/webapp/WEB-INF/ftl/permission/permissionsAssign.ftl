<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>权限分配</title>


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
                    <h3>角色权限分配</small></h3>
                    <hr/>
                    <form id="formId" method="post" action="">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group  top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="输入角色名查询" name="findContent"/>
                                <span class="input-group-btn">
                                    <input class="btn btn-default" type="submit" value="查询"/>
                                </span>
                            </div>
                        </div>
                    </form>
                </div>
                <div>
                    <table class="table table-striped jambo_table bulk_action">
                        <input type="hidden" id="selectPermissionId">
                        <tr>
                            <td>序号</td>
                            <td>角色名</td>
                            <td>拥有的权限</td>
                            <td>操作</td>
                        </tr>
                        <#if ulist?size gt 0>
                            <#list ulist as list>
                         <tr>
                             <td>${list_index+1}</td>
                             <td>${list.name}</td>
                             <td permissionIds="${list.permissionIds?default('')}">${list.permissionNames?default('-')}</td>
                             <td>
                                 <i class="glyphicon glyphicon-share-alt"></i>
                                 <a href="javascript:selectPermissionById(${list.id});">选择权限</a>
                             </td>
                         </tr>
                            </#list>
                        <#elseif !results>
                            <tr>
                                <td class="text-center danger" colspan="4">没有找到权限</td>
                            </tr>
                        </#if>
                    </table>
                    <#if totalPage gt 0>
                        <ul class="pagination" style=" width: auto;display: table;margin-left: auto;margin-right:auto">
                            <li><a href="#">&laquo;</a></li>
                            <#list 1..totalPage as it >
                                <li>
                                    <a href=javascript:pageDo(${it})>${it}</a>
                                </li>
                            </#list>
                            <li><a href="#">&raquo;</a></li>
                        </ul>
                        <br>
                    </#if>
                </div>
            </div>
            <div class="modal fade bs-example-modal-sm" id="selectRole" tabindex="-1" role="dialog"
                 aria-labelledby="selectRoleLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="selectRoleLabel">添加权限</h4>
                        </div>
                        <div class="modal-body">
                            <form id="boxPermissionForm">
                                loading...
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" onclick="selectPermission();" class="btn btn-primary">Save</button>
                        </div>
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
<#--layer.js-->
<script src="/js/common/layer/layer.js"></script>
<#--form.js-->
<script src="/js/common/jquery-form.js"></script>
<#--Shiro.js-->
<script src="/js/shiro.js"></script>
<script>
    function pageDo(page) {
        var url = "/permission/assign?pageNow=" + page;
        window.location.href = url;
    }

    function selectPermission() {
        var checked = $("#boxPermissionForm  :checked");
        var ids = [], names = [];
        $.each(checked, function () {
            ids.push(this.id);
            /*name 权限名称*/
            names.push($.trim($(this).attr('name')));
        });
        var index = layer.confirm("确定操作？", function () {
        <#--loding-->
            var load = layer.load();
            $.post('/role/addRole2User', {ids: ids.join(','), userId: $('#selectUserId').val()}, function (result) {
                layer.close(load);
                if (result && result.status != 200) {
                    return layer.msg(result.message, so.default), !1;
                }
                layer.msg('添加成功。');
                setTimeout(function () {
                    window.location.href = "assign?pageNow=1";
                }, 1000);
            }, 'json');
        });
    }

    /*
    *根据角色ID选择权限，分配权限操作。
    */
    function selectPermissionById(id) {
        var load = layer.load();
        $.post("/permission/selectPermissionByRoleId", {id: id}, function (result) {
            console.log(result);
            layer.close(load);
            if (result && result.length) {
                var html = [];
                $.each(result, function () {
                    html.push("<div class='checkbox'><label>");
                    html.push("<input type='checkbox' id='");
                    html.push(this.id);
                    html.push("'");
                    if (this.check) {
                        html.push(" checked='checked'");
                    }
                    html.push("name='");
                    html.push(this.name);
                    html.push("'/>");
                    html.push(this.name);
                    html.push('</label></div>');
                });
                return so.id('boxPermissionForm').html(html.join('')) & $('#selectPermission').modal(), $('#selectRoleId').val(id), !1;
            } else {
                return layer.msg('没有获取到用户数据，请先注册数据。', so.default);
            }
        }, 'json');
    }
    <#--</@shiro.hasPermission>-->
</script>
</body>
</html>
