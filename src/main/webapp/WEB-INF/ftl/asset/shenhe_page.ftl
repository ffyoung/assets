<#--录入人员进行录入页面-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>资产录入</title>

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
                <h3>资产信息审核</small></h3>
            </div>
            <div class="clearfix"></div>
            </div>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>资产审核</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <br/>
                        <form id="assetsform" data-parsley-validate class="form-horizontal form-label-left">

                            <input type="text" id="id" name="id" required="required" hidden="hidden" readonly="readonly" value="${assets.id}"/>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">入库日期
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="date" id="storageDate" name="storageDate" required="required" class="form-control col-md-7 col-xs-12"
                                    value="${assets.storageDate?string("yyyy-MM-dd")}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">物品名称
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="itemName" name="itemName" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.itemName}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">编码
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="coding" name="coding" required="required"
                                     class="form-control col-md-7 col-xs-12" value="${assets.coding}" />
                                </div>
                            </div>

                            <div class=" form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">规格
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="standard" name="standard" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.standard}"/>
                                </div>
                            </div>

                            <div class=" form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">型号
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="model" name="model" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.model}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">数量
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="inCount" name="inCount" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.inCount}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">单位
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="unit" name="unit" required="required"
                                   class="form-control col-md-7 col-xs-12" value="${assets.unit}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">价格
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="price" name="price" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.price}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">价值
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="value" name="value" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.value}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">产权单位
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="propertyUnit" name="propertyUnit" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.propertyUnit}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">购置日期
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="date" id="buyDate" name="buyDate" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.buyDate?string("yyyy-MM-dd")}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">出库日期
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="date" id="outDate" name="outDate" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.outDate?string("yyyy-MM-dd")}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">出库数量
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="outCount" name="outCount" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.outCount}"/>
                                </div>
                            </div>

                            <div class=" form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="first-name">产地
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="area" name="area" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.area}"/>
                                </div>
                            </div>

                            <div class=" form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">物品分类
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="goodsType" name="goodsType" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.goodsProperty}"/>
                                </div>
                            </div>

                            <div class=" form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">物品属性
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="goodsProperty" name="goodsProperty"  required="required"
                                    class="form-control col-md-7 col-xs-12"  value="${assets.goodsProperty}"/>
                                </div>
                            </div>

                            <div class=" form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">管理状态
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="managerStatus"  name="managerStatus" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.managerStatus}"/>

                                    </div>
                                </div>
                            <div class=" form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">使用单位
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="unitUse" name="unitUse"  class="form-control col-md-7 col-xs-12"
                                     value="${assets.unitUse}"/>
                                </div>
                            </div>

                            <div class=" form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">管理责任人
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="manager" name="manager" required="required"
                                    class="form-control col-md-7 col-xs-12" value="${assets.manager}"/>
                                </div>
                            </div>

                            <#--信息录入-->
                            <input type="text" id="inputMessage"  name="inputMessage"  required="required" readonly="readonly"
                             value="${assets.inputMessage}" hidden="hidden"/>

                             <input type="date" id="inputDate" name="inputDate" readonly="readonly" hidden="hidden"
                                    required="required" value="${assets.inputDate?string("yyyy-MM-dd")}"/>

                            <input type="text" id="auditor" name="auditor"  required="required" readonly
                             value="${user.username?default('-')}" hidden/>
                            <input type="date" id="auditorDate" name="auditorDate" required="required" readonly="readonly"
                             hidden="hidden"  value="${dateNow?string("yyyy-MM-dd")}"/>

                            <#--<div class="form-group">-->
                            <#--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">核准人 <span-->
                            <#--class="required">*</span>-->
                            <#--</label>-->
                            <#--<div class="col-md-6 col-sm-6 col-xs-12">-->
                            <#--<input type="text" id="authorizer" name="authorizer" required="required"-->
                            <#--class="form-control col-md-7 col-xs-12"/>-->
                            <#--</div>-->
                            <#--</div>-->

                            <#--<div class="form-group">-->
                            <#--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">核准日期 <span-->
                            <#--class="required">*</span>-->
                            <#--</label>-->
                            <#--<div class="col-md-6 col-sm-6 col-xs-12">-->
                            <#--<input type="date" id="authorizerDate" name="authorizerDate" required="required"-->
                            <#--class="form-control col-md-7 col-xs-12"/>-->
                            <#--</div>-->
                            <#--</div>-->

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" >附图
                                    <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="picture" name="picture" required="required"
                                           class="form-control col-md-7 col-xs-12"
                                           value="${assets.picture?default("")}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">用途
                                     <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="useType" name="useType" required="required"
                                           class="form-control col-md-7 col-xs-12"
                                           value="${assets.useType?default("")}"/>

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" >备注说明
                                   <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="remark" name="remark" required="required"
                                           class="form-control col-md-7 col-xs-12"
                                           value="${assets.remark?default("")}"/>
                                </div>
                            </div>

                            <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <button type="button" id="sub" class="btn btn-success">确认审核</button>
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
                var form = $("#assetsform");
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
                $.post("/asset/updateMsg", $("#assetsform").serialize(), function (result) {
                    layer.close(load);
                    if (result && result.status != 200) {
                        return layer.msg(result.message, function () {
                        }), !1;
                    } else {
                        layer.msg('修改成功!');
                        setTimeout(function () {
                            window.location.href = "/asset/all?pageNow=1";
                        }, 2000);
                    }
                }, "json");
            })
    )
</script>
</body>
</html>
