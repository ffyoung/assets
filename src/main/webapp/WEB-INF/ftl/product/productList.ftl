<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>价格列表</title>

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
                    <h3>价格列表</small></h3>
                    <hr/>
                    <form id="formId" method="post" action="/product/all" autocomplete="off">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group  top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search for..." name="findContent"
                                       value="${findContent?default('')}" id="findContent" />
                                <span class="input-group-btn">
                                    <input class="btn btn-default" type="submit">Go!</input>
                                </span>
                            </div>
                        </div>
                </div>
            </div>
            <table class="table table-striped jambo_table bulk_action">
                <tr>
                <#--<td><input type="checkbox" id="check-all" class="flat"></td>-->
                    <td >序号</td>
                    <td >物品名称</td>
                    <td>价格(元)</td>
                </tr>
                 <#if assetslist?size gt 0>
                     <#list assetslist as list>
                <tr>
                    <td>${(currentPage-1)*10+list_index+1}</td>
                    <td>${list.itemName}</td>

                    <#--业务员-->
                    <@shiro.hasAnyRoles name="99999,88888">
                    <td>${list.price+500}</td>
                    </@shiro.hasAnyRoles>

                    <#--销售人员-->
                    <@shiro.hasAnyRoles name="55555">
                    <td>${list.price+1000}</td>
                    </@shiro.hasAnyRoles>

                    <#--业务员-->
                    <@shiro.hasAnyRoles name="66666">
                    <td>${list.price+500}</td>
                    </@shiro.hasAnyRoles>
                </tr>
                     </#list>
                 <#elseif !results>
                <tr>
                    <td class="text-center danger" colspan="3">没有找产品</td>
                </tr>
                     </#if>
            </table>
            <div id="complete"></div>
            </form>
        </div>
    <#--^^^^^^^^^^^^^^^^^^^^^-->
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
<script src="/js/common/page/pageDo.js"></script>

<!-- bootstrap-daterangepicker -->
<script src="/js/common/dist/moment.min.js"></script>
<script src="/js/common/dist/daterangepicker.js"></script>
</body>
<script>




    <#--分页-->
    $(function () {
        PagingManage($('#complete'),${totalPage},10, ${currentPage});
    });

    /*更改信息页面跳转*/
    function updateMsg(id) {
        var url = "/asset/updateDo/" + id;
        window.location.href = url;
    }


    //分页跳转
    function pageDo(page){
        var wd = $("#findContent").val();
        var url = "/product/all?pageNow="+page+"&findContent="+wd;
        window.location.href = url;
    }

    $("#shouqi").click(function () {
        $("#shouqi").css('display','none');
        $("#showDate").css('display','none');
        $("#zhankai").css('display','block');
    });

    $("#zhankai").click(function () {
        $("#zhankai").css('display','none');
        $("#showDate").css('display','block');
        $("#shouqi").css('display','block');
    });



</script>

</html>
