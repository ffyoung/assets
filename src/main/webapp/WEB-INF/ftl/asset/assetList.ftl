<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>资产列表</title>

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
                    <h3>资产列表</small></h3>
                    <div style="position: absolute;right: 1cm;">
                        <@shiro.hasAnyRoles name="11111">
                            <a href="/asset/addAssetsIndex" class="btn btn-default">新增资产</a>
                        </@shiro.hasAnyRoles>
                    </div>
                        <div>
                            <span id="shouqi" style="display: none;">点击收起</span>
                            <span id="zhankai">点击展开</span>
                        </div>
                    <hr/>
                    <div id="showDate" style="width: auto;height: 200px; display: none;">

                        <form action="/asset/findByStore" method="post">
                            <div>
                                <h4>入库日期</h4>
                                <label>开始时间</label>
                            <#--<td>${it.time?string('yyyy-MM-dd HH:mm')}</td>-->
                                <input type="date" id="starttime" name="starttime" />
                                <label>结束时间</label>
                                <input type="date" id="endtime" name="endtime"/>
                                <input type="submit" value="提交" />
                            </div>
                        </form>
                    <#------------------------------------------------------>
                        <form action="/asset/findByBuy" method="post">
                            <div>
                                <h4>购置日期</h4>
                                <label>开始时间</label>
                                <input type="date" id="starttime" name="starttime" />
                                <label>结束时间</label>
                                <input type="date" id="endtime" name="endtime"/>
                                <input type="submit" value="提交" />
                            </div>
                        </form>
                        <#------------------------------------------------------>
                        <form action="/asset/findByOut" method="post">
                            <div>
                                <h4>出库日期</h4>
                                <label>开始时间</label>
                                <input type="date" id="starttime" name="starttime" />
                                <label>结束时间</label>
                                <input type="date" id="endtime" name="endtime"/>
                                <input type="submit" value="提交" />
                            </div>
                        </form>
                    </div>

            <form id="formId" method="post" action="/asset/all" autocomplete="off">
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
                            <td >入库日期</td>
                            <td >物品名称</td>
                            <td>编码</td>
                            <td>规格</td>
                            <td>型号</td>
                            <td>入库数量</td>
                            <td>单位</td>
                            <td>价格(元)</td>
                            <td>估值</td>
                            <td>产权单位(人)</td>
                            <td>购置日期</td>
                            <td>出库日期</td>
                            <td>出库数量</td>
                            <td>库存</td>
                            <td>产地</td>
                            <td>物品分类</td>
                            <td>物品属性</td>
                            <td>管理状态</td>
                            <td>使用单位(人)</td>
                            <td>管理责任人</td>
                            <td>信息录入</td>
                            <td>录入日期</td>
                            <td>审核人</td>
                            <td>审核日期</td>
                            <td>核准人</td>
                            <td>核准日期</td>
                            <td>附图</td>
                            <td>用途</td>
                            <td>备注说明</td>
                            <@shiro.hasAnyRoles name="22222,33333,99999">
                            <td>操作</td>
                            </@shiro.hasAnyRoles>
                        </tr>
                         <#if assetslist?size gt 0>
                             <#list assetslist as list>
                        <tr>
                         <#--<td class="a-center ">-->
                             <#--<input type="checkbox" class="flat" name="table_records">-->
                         <#--</td>-->
                            <td>${(currentPage-1)*10+list_index+1}</td>
                            <td>${list.storageDate?date}</td>
                            <td>${list.itemName}</td>
                            <td>${list.coding}</td>
                            <td>${list.standard}</td>
                            <td>${list.model}</td>
                            <td>${list.inCount}</td>
                            <td>${list.unit}</td>
                            <td>${list.price}</td>
                            <td>${list.value}</td>
                            <td>${list.propertyUnit}</td>
                            <td>${list.buyDate?date}</td>
                            <td>${list.outDate?date}</td>
                            <td>${list.outCount}</td>
                            <td>${list.inCount - list.outCount}</td>
                            <td>${list.area}</td>
                            <td>${list.goodsType}</td>
                            <td>${list.goodsProperty}</td>
                            <td>${list.managerStatus}</td>
                            <td>${list.unitUse}</td>
                            <td>${list.manager}</td>
                             <#--录入员-->
                            <td>${list.inputMessage}</td>
                            <td>${list.inputDate?date}</td>

                             <#--审核员-->
                            <td>${list.auditor?default("")}</td>
                            <#--<td>${list.auditor?length}</td>-->
                            <td>${(list.auditorDate?date)!}</td>

                            <#--批准员-->
                            <td>${list.authorizer?default("")}</td>
                            <#--<td>${(list.authorizer?length)?default(0)}</td>-->
                            <td>${(list.authorizerDate?date)!}</td>

                             <td>${list.picture?default("")}</td>
                             <td>${list.useType?default("")}</td>
                             <td>${list.remark?default("")}</td>


                             <#--审批员-->
                             <#--<@shiro.hasAnyRoles name="22222,99999">-->
                             <@shiro.hasAnyRoles name="22222">
                                 <#if (list.auditor?length)?default(0) == 0>
                             <td><a href="javascript:updateMsg(${list.id})" class="btn btn-default">审核</a></td>
                                 </#if>
                             </@shiro.hasAnyRoles>

                             <#--批准员-->
                            <@shiro.hasAnyRoles name="33333">
                                <#if (list.authorizer?length)?default(0) == 0 && ((list.auditor?length)?default(0) > 0) >
                            <td><a href="javascript:Pizhun(${list.id})" class="btn btn-default">分配</a></td>
                            </#if>
                            </@shiro.hasAnyRoles>
                        </tr>
                             </#list>
                    <#elseif !results>
                    <tr>
                        <td class="text-center danger" colspan="31">没有找到用户</td>
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

    /*更改信息页面跳转*/
    function Pizhun(id) {
        var url = "/asset/pizhunDo/" + id;
        window.location.href = url;
    }




    //分页跳转
    function pageDo(page){
        var wd = $("#findContent").val();
        var url = "/asset/all?pageNow="+page+"&findContent="+wd;
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
