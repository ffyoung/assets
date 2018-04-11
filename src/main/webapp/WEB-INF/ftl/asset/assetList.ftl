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
                        <a href="/asset/addAssetsIndex" class="btn btn-default">新增资产</a>
                    </div>
                    <hr/>
                    <form id="formId" method="post" action="/asset/findByCont">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group  top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search for..." name="findContent" />
                                <span class="input-group-btn">
                                    <input class="btn btn-default" type="submit">Go!</input>
                                </span>
                          </div>
                       </div>
                </div>
                <div>
                    <table class="table table-striped jambo_table bulk_action">

                        <tr>
                            <td><input type="checkbox" id="check-all" class="flat"></td>
                            <td>入库日期</td>
                            <td>物品名称</td>
                            <td>编码</td>
                            <td>规格</td>
                            <td>型号</td>
                            <td>数量</td>
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
                        </tr>
                     <tr >
                          <#list assetslist as list>
                         <td class="a-center ">
                             <input type="checkbox" class="flat" name="table_records">
                         </td>
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
                            <td>${list.inputMessage}</td>
                            <td>${list.inputDate?date}</td>
                            <td>${list.auditor}</td>
                            <td>${list.auditorDate?date}</td>
                            <td>${list.authorizer}</td>
                            <td>${list.authorizerDate?date}</td>
                            <td>${list.picture}</td>
                            <td>${list.useType}</td>
                            <td>${list.remark}</td>
                        </tr>
                    </#list>
                </table>

                        <input id="page" name="pageNow" value="1" disabled />
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

</body>
</html>
