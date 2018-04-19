<#macro left>
 <div class="col-md-3 left_col">
     <div class="left_col scroll-view">
         <div class="navbar nav_title" style="border: 0;">
             <a href="main.ftl" class="site_title"><i class="fa fa-leaf"></i> <span>乾元文化</span></a>
         </div>

         <div class="clearfix"></div>

         <!-- menu profile quick info -->
         <div class="profile clearfix">
             <#--图片添加-->
             <#--<div class="profile_pic">-->
                 <#--<img src="" alt="..." class="img-circle profile_img">-->
             <#--</div>-->
             <#--<div class="profile_info">-->
                 <#--<span>欢迎你,</span>-->
                 <#--<h2></h2>-->
             <#--</div>-->
         </div>
         <!-- /menu profile quick info -->

         <br/>

         <!-- sidebar menu -->
         <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
             <div class="menu_section">
                 <ul class="nav side-menu">

                     <li><a><i class="fa fa-home"></i> 资产管理 <span class="fa fa-chevron-down"></span></a>
                         <ul class="nav child_menu">
                             <@shiro.hasAnyRoles name="99999">
                             <li><a href="/asset/all?pageNow=1">列表</a></li>
                             </@shiro.hasAnyRoles>
                             <#list departlist as list>
                                 <li><a href="/asset/all?pageNow=1">${list.name}</a></li>
                             </#list>
                         </ul>
                     </li>

                     <@shiro.hasAnyRoles name="99999">
                     <li><a><i class="fa fa-edit"></i> 角色管理 <span class="fa fa-chevron-down"></span></a>
                         <ul class="nav child_menu">
                             <li><a href="/role/all?pageNow=1">角色列表</a></li>
                             <li><a href="/role/assign?pageNow=1">用户角色分配</a></li>
                         </ul>
                     </li>
                     </@shiro.hasAnyRoles>
                     <li><a><i class="fa fa-desktop"></i> 权限管理 <span
                             class="fa fa-chevron-down"></span></a>
                         <ul class="nav child_menu">
                             <li><a href="/permission/all?pageNow=1">权限列表</a></li>
                             <li><a href="/permission/assign?pageNow=1">角色权限分配</a></li>
                         </ul>
                     </li>
                     <li><a><i class="fa fa-table"></i> 部门管理 <span class="fa fa-chevron-down"></span></a>
                         <ul class="nav child_menu">
                             <li><a href="/depart/all?pageNow=1">部门列表</a></li>
                             <li><a href="/depart/assign?pageNow=1">用户部门分配</a></li>
                         </ul>
                     </li>
                     <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span
                             class="fa fa-chevron-down"></span></a>
                         <ul class="nav child_menu">
                             <li><a href="chartjs.html">Chart JS</a></li>
                             <li><a href="chartjs2.html">Chart JS2</a></li>
                             <li><a href="morisjs.html">Moris JS</a></li>
                             <li><a href="echarts.html">ECharts</a></li>
                             <li><a href="other_charts.html">Other Charts</a></li>
                         </ul>
                     </li>
                     <li><a><i class="fa fa-clone"></i>产品<span class="fa fa-chevron-down"></span></a>
                         <ul class="nav child_menu">
                             <li><a href="/product/all?pageNow=1">价格</a></li>
                             <li><a href="#">价格B</a></li>
                         </ul>
                     </li>
                 </ul>
             </div>
             <div class="menu_section">
                 <h3>Live On</h3>
                 <ul class="nav side-menu">
                     <li><a><i class="fa fa-bug"></i> Additional Pages <span
                             class="fa fa-chevron-down"></span></a>
                         <ul class="nav child_menu">
                             <li><a href="e_commerce.html">E-commerce</a></li>
                             <li><a href="projects.html">Projects</a></li>
                             <li><a href="project_detail.html">Project Detail</a></li>
                             <li><a href="contacts.html">Contacts</a></li>
                             <li><a href="profile.html">Profile</a></li>
                         </ul>
                     </li>
                     <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                         <ul class="nav child_menu">
                             <li><a href="page_403.html">403 Error</a></li>
                             <li><a href="page_404.html">404 Error</a></li>
                             <li><a href="page_500.html">500 Error</a></li>
                             <li><a href="plain_page.html">Plain Page</a></li>
                             <li><a href="login.html">Login Page</a></li>
                             <li><a href="pricing_tables.html">Pricing Tables</a></li>
                         </ul>
                     </li>
                     <li><a><i class="fa fa-sitemap"></i> Multilevel Menu <span
                             class="fa fa-chevron-down"></span></a>
                         <ul class="nav child_menu">
                             <li><a href="#level1_1">Level One</a>
                             <li><a>Level One<span class="fa fa-chevron-down"></span></a>
                                 <ul class="nav child_menu">
                                     <li class="sub_menu"><a href="level2.html">Level Two</a>
                                     </li>
                                     <li><a href="#level2_1">Level Two</a>
                                     </li>
                                     <li><a href="#level2_2">Level Two</a>
                                     </li>
                                 </ul>
                             </li>
                             <li><a href="#level1_2">Level One</a>
                             </li>
                         </ul>
                     </li>
                     <li><a href="javascript:void(0)"><i class="fa fa-laptop"></i> Landing Page <span
                             class="label label-success pull-right">Coming Soon</span></a></li>
                 </ul>
             </div>

         </div>
         <!-- /sidebar menu -->

         <!-- /menu footer buttons -->
         <div class="sidebar-footer hidden-small">
             <a data-toggle="tooltip" data-placement="top" title="Settings">
                 <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
             </a>
             <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                 <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
             </a>
             <a data-toggle="tooltip" data-placement="top" title="Lock">
                 <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
             </a>
             <a data-toggle="tooltip" data-placement="top" title="Logout" href="/user/logout">
                 <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
             </a>
         </div>
         <!-- /menu footer buttons -->
     </div>
 </div>
</#macro>