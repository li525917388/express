<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" href="favicon.ico">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台管理系统</title>
	
	<link href="${contextPath}/static/Hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link href="${contextPath}/static/Hplus/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
	<link href="${contextPath}/static/Hplus/css/animate.css" rel="stylesheet">
	<link href="${contextPath}/static/Hplus/css/style.css?v=4.1.0" rel="stylesheet">
	
	<style>
	/* 布局中心区的iframe样式 */
	#ldh_content_iframe{
		border: none !important;
	}
	</style>
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
	<nav class="navbar-default navbar-static-side" role="navigation">
		<div class="nav-close"><i class="fa fa-times-circle"></i>
	    </div>
	    <div class="sidebar-collapse">
	        <ul class="nav" id="side-menu">
	            <li class="nav-header">
	                <div class="dropdown profile-element">
	                    <span><img alt="image" class="img-circle" src="${contextPath}/static/Hplus/img/profile_small.jpg" /></span>
	                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
	                                <span class="clear">
	                               <span class="block m-t-xs"><strong class="font-bold">Beaut-zihan</strong></span>
	                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
	                                </span>
	                    </a>
	                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
	                        <li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
	                        </li>
	                        <li><a class="J_menuItem" href="profile.html">个人资料</a>
	                        </li>
	                        <li><a class="J_menuItem" href="contacts.html">联系我们</a>
	                        </li>
	                        <li><a class="J_menuItem" href="mailbox.html">信箱</a>
	                        </li>
	                        <li class="divider"></li>
	                        <li><a href="login.html">安全退出</a>
	                        </li>
	                    </ul>
	                </div>
	                <div class="logo-element">H+
	                </div>
	            </li>
	            
	            <%-- <c:forEach items="${user_role_menus }" var="m">
	             <li>
	                <a href="#">
	                    <i class="fa fa-${m.icon} }"></i>
	                    <span class="nav-label">${m.menuName } </span>
	                    <span class="fa arrow"></span>
	                </a>
	                <ul class="nav nav-second-level">
	                	<c:forEach items="${m.childList }" var="cm">
	                	<li>
	                        <a class="J_menuItem" href="${pageContext.request.contextPath}/${cm.url }">${cm.menuName }</a>
	                    </li>
	                	</c:forEach>
	                </ul>
	
	            </li>
	            
	            </c:forEach> --%>
	           
	            
	            
	
	            
	           <li>
	                <a href="#">
	                    <i class="fa fa-home"></i>
	                    <span class="nav-label">主页</span>
	                    <span class="fa arrow"></span>
	                </a>
	                <ul class="nav nav-second-level">
	                    <li>
	                        <a class="J_menuItem" href="index_v1.html" data-index="0">主页示例一</a>
	                    </li>
	                    <li>
	                        <a class="J_menuItem" href="index_v2.html">主页示例二</a>
	                    </li>
	                    <li>
	                        <a class="J_menuItem" href="index_v3.html">主页示例三</a>
	                    </li>
	                    <li>
	                        <a class="J_menuItem" href="index_v4.html">主页示例四</a>
	                    </li>
	                    <li>
	                        <a href="index_v5.html" target="_blank">主页示例五</a>
	                    </li>
	                </ul>
	
	            </li>
	            <li>
	                <a class="J_menuItem" href="layouts.html"><i class="fa fa-columns"></i> <span class="nav-label">布局</span></a>
	            </li>
	            <li>
	                <a href="#">
	                    <i class="fa fa fa-bar-chart-o"></i>
	                    <span class="nav-label">统计图表</span>
	                    <span class="fa arrow"></span>
	                </a>
	                <ul class="nav nav-second-level">
	                    <li>
	                        <a class="J_menuItem" href="graph_echarts.html">百度ECharts</a>
	                    </li>
	                    <li>
	                        <a class="J_menuItem" href="graph_flot.html">Flot</a>
	                    </li>
	                    <li>
	                        <a class="J_menuItem" href="graph_morris.html">Morris.js</a>
	                    </li>
	                    <li>
	                        <a class="J_menuItem" href="graph_rickshaw.html">Rickshaw</a>
	                    </li>
	                    <li>
	                        <a class="J_menuItem" href="graph_peity.html">Peity</a>
	                    </li>
	                    <li>
	                        <a class="J_menuItem" href="graph_sparkline.html">Sparkline</a>
	                    </li>
	                    <li>
	                        <a class="J_menuItem" href="graph_metrics.html">图表组合</a>
	                    </li>
	                </ul>
	            </li>
	
	            <li>
	                <a href="mailbox.html"><i class="fa fa-envelope"></i> <span class="nav-label">信箱 </span><span class="label label-warning pull-right">16</span></a>
	                <ul class="nav nav-second-level">
	                    <li><a class="J_menuItem" href="mailbox.html">收件箱</a>
	                    </li>
	                    <li><a class="J_menuItem" href="mail_detail.html">查看邮件</a>
	                    </li>
	                    <li><a class="J_menuItem" href="mail_compose.html">写信</a>
	                    </li>
	                </ul>
	            </li>
	            <li>
	                <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">表单</span><span class="fa arrow"></span></a>
	                <ul class="nav nav-second-level">
	                    <li><a class="J_menuItem" href="${pageContext.request.contextPath}/admin/index/form_basic">基本表单</a>
	                    </li>
	                    <li><a class="J_menuItem" href="${pageContext.request.contextPath}/admin/index/form_validate">表单验证</a>
	                    </li>
	                    <li><a class="J_menuItem" href="form_advanced.html">高级插件</a>
	                    </li>
	                    <li><a class="J_menuItem" href="form_wizard.html">表单向导</a>
	                    </li>
	                    <li>
	                        <a href="#">文件上传 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li><a class="J_menuItem" href="form_webuploader.html">百度WebUploader</a>
	                            </li>
	                            <li><a class="J_menuItem" href="form_file_upload.html">DropzoneJS</a>
	                            </li>
	                            <li><a class="J_menuItem" href="form_avatar.html">头像裁剪上传</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="#">编辑器 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li><a class="J_menuItem" href="form_editors.html">富文本编辑器</a>
	                            </li>
	                            <li><a class="J_menuItem" href="form_simditor.html">simditor</a>
	                            </li>
	                            <li><a class="J_menuItem" href="form_markdown.html">MarkDown编辑器</a>
	                            </li>
	                            <li><a class="J_menuItem" href="code_editor.html">代码编辑器</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li><a class="J_menuItem" href="suggest.html">搜索自动补全</a>
	                    </li>
	                    <li><a class="J_menuItem" href="layerdate.html">日期选择器layerDate</a>
	                    </li>
	                </ul>
	            </li>
	            <li>
	                <a href="#"><i class="fa fa-desktop"></i> <span class="nav-label">页面</span><span class="fa arrow"></span></a>
	                <ul class="nav nav-second-level">
	                    <li><a class="J_menuItem" href="contacts.html">联系人</a>
	                    </li>
	                    <li><a class="J_menuItem" href="profile.html">个人资料</a>
	                    </li>
	                    <li>
	                        <a href="#">项目管理 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li><a class="J_menuItem" href="projects.html">项目</a>
	                            </li>
	                            <li><a class="J_menuItem" href="project_detail.html">项目详情</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li><a class="J_menuItem" href="teams_board.html">团队管理</a>
	                    </li>
	                    <li><a class="J_menuItem" href="social_feed.html">信息流</a>
	                    </li>
	                    <li><a class="J_menuItem" href="clients.html">客户管理</a>
	                    </li>
	                    <li><a class="J_menuItem" href="file_manager.html">文件管理器</a>
	                    </li>
	                    <li><a class="J_menuItem" href="calendar.html">日历</a>
	                    </li>
	                    <li>
	                        <a href="#">博客 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li><a class="J_menuItem" href="blog.html">文章列表</a>
	                            </li>
	                            <li><a class="J_menuItem" href="article.html">文章详情</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li><a class="J_menuItem" href="faq.html">FAQ</a>
	                    </li>
	                    <li>
	                        <a href="#">时间轴 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li><a class="J_menuItem" href="timeline.html">时间轴</a>
	                            </li>
	                            <li><a class="J_menuItem" href="timeline_v2.html">时间轴v2</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li><a class="J_menuItem" href="pin_board.html">标签墙</a>
	                    </li>
	                    <li>
	                        <a href="#">单据 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li><a class="J_menuItem" href="invoice.html">单据</a>
	                            </li>
	                            <li><a class="J_menuItem" href="invoice_print.html">单据打印</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li><a class="J_menuItem" href="search_results.html">搜索结果</a>
	                    </li>
	                    <li><a class="J_menuItem" href="forum_main.html">论坛</a>
	                    </li>
	                    <li>
	                        <a href="#">即时通讯 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li><a class="J_menuItem" href="chat_view.html">聊天窗口</a>
	                            </li>
	                            <li><a class="J_menuItem" href="webim.html">layIM</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="#">登录注册相关 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li><a href="login.html" target="_blank">登录页面</a>
	                            </li>
	                            <li><a href="login_v2.html" target="_blank">登录页面v2</a>
	                            </li>
	                            <li><a href="register.html" target="_blank">注册页面</a>
	                            </li>
	                            <li><a href="lockscreen.html" target="_blank">登录超时</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li><a class="J_menuItem" href="404.jsp">404页面</a>
	                    </li>
	                    <li><a class="J_menuItem" href="500.html">500页面</a>
	                    </li>
	                    <li><a class="J_menuItem" href="empty_page.html">空白页</a>
	                    </li>
	                </ul>
	            </li>
	            <li>
	                <a href="#"><i class="fa fa-flask"></i> <span class="nav-label">UI元素</span><span class="fa arrow"></span></a>
	                <ul class="nav nav-second-level">
	                    <li><a class="J_menuItem" href="typography.html">排版</a>
	                    </li>
	                    <li>
	                        <a href="#">字体图标 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li>
	                                <a class="J_menuItem" href="fontawesome.html">Font Awesome</a>
	                            </li>
	                            <li>
	                                <a class="J_menuItem" href="glyphicons.html">Glyphicon</a>
	                            </li>
	                            <li>
	                                <a class="J_menuItem" href="iconfont.html">阿里巴巴矢量图标库</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="#">拖动排序 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li><a class="J_menuItem" href="draggable_panels.html">拖动面板</a>
	                            </li>
	                            <li><a class="J_menuItem" href="agile_board.html">任务清单</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li><a class="J_menuItem" href="buttons.html">按钮</a>
	                    </li>
	                    <li><a class="J_menuItem" href="tabs_panels.html">选项卡 &amp; 面板</a>
	                    </li>
	                    <li><a class="J_menuItem" href="notifications.html">通知 &amp; 提示</a>
	                    </li>
	                    <li><a class="J_menuItem" href="badges_labels.html">徽章，标签，进度条</a>
	                    </li>
	                    <li>
	                        <a class="J_menuItem" href="grid_options.html">栅格</a>
	                    </li>
	                    <li><a class="J_menuItem" href="plyr.html">视频、音频</a>
	                    </li>
	                    <li>
	                        <a href="#">弹框插件 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li><a class="J_menuItem" href="layer.html">Web弹层组件layer</a>
	                            </li>
	                            <li><a class="J_menuItem" href="modal_window.html">模态窗口</a>
	                            </li>
	                            <li><a class="J_menuItem" href="sweetalert.html">SweetAlert</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="#">树形视图 <span class="fa arrow"></span></a>
	                        <ul class="nav nav-third-level">
	                            <li><a class="J_menuItem" href="jstree.html">jsTree</a>
	                            </li>
	                            <li><a class="J_menuItem" href="tree_view.html">Bootstrap Tree View</a>
	                            </li>
	                            <li><a class="J_menuItem" href="nestable_list.html">nestable</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li><a class="J_menuItem" href="toastr_notifications.html">Toastr通知</a>
	                    </li>
	                    <li><a class="J_menuItem" href="diff.html">文本对比</a>
	                    </li>
	                    <li><a class="J_menuItem" href="spinners.html">加载动画</a>
	                    </li>
	                    <li><a class="J_menuItem" href="widgets.html">小部件</a>
	                    </li>
	                </ul>
	            </li>
	            <li>
	                <a href="#"><i class="fa fa-table"></i> <span class="nav-label">表格</span><span class="fa arrow"></span></a>
	                <ul class="nav nav-second-level">
	                    <li><a class="J_menuItem" href="table_basic.html">基本表格</a>
	                    </li>
	                    <li><a class="J_menuItem" href="table_data_tables.html">DataTables</a>
	                    </li>
	                    <li><a class="J_menuItem" href="table_jqgrid.html">jqGrid</a>
	                    </li>
	                    <li><a class="J_menuItem" href="table_foo_table.html">Foo Tables</a>
	                    </li>
	                    <li><a class="J_menuItem" href="table_bootstrap.html">Bootstrap Table
	                        <span class="label label-danger pull-right">推荐</span></a>
	                    </li>
	                </ul>
	            </li>
	            <li>
	                <a href="#"><i class="fa fa-picture-o"></i> <span class="nav-label">相册</span><span class="fa arrow"></span></a>
	                <ul class="nav nav-second-level">
	                    <li><a class="J_menuItem" href="basic_gallery.html">基本图库</a>
	                    </li>
	                    <li><a class="J_menuItem" href="carousel.html">图片切换</a>
	                    </li>
	                    <li><a class="J_menuItem" href="blueimp.html">Blueimp相册</a>
	                    </li>
	                </ul>
	            </li>
	            <li>
	                <a class="J_menuItem" href="css_animation.html"><i class="fa fa-magic"></i> <span class="nav-label">CSS动画</span></a>
	            </li>
	            <li>
	                <a href="#"><i class="fa fa-cutlery"></i> <span class="nav-label">工具 </span><span class="fa arrow"></span></a>
	                <ul class="nav nav-second-level">
	                    <li><a class="J_menuItem" href="form_builder.html">表单构建器</a>
	                    </li>
	                </ul>
	            </li>
	
	        </ul>
	    </div>
	</nav>
	
	
	
	<input type="hidden" id="contextPath_input" value="${contextPath}"/>
	<div id="page-wrapper" class="gray-bg dashbard-1">
	    <div class="row border-bottom">
	        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
	            <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
	                <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
	                    <div class="form-group">
	                        <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
	                    </div>
	                </form>
	            </div>
	            <ul class="nav navbar-top-links navbar-right">
	
	                <li class="hidden-xs">
	                    <a href="index_v1.html" class="J_menuItem" data-index="0"><i class="fa fa-cart-arrow-down"></i> 购买</a>
	                </li>
	                <li class="dropdown hidden-xs">
	                    <a class="right-sidebar-toggle" aria-expanded="false">
	                        <i class="fa fa-tasks"></i> 主题
	                    </a>
	                </li>
	            </ul>
	        </nav>
	    </div>
	    <div class="row content-tabs">
	        <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
	        </button>
	        <nav class="page-tabs J_menuTabs">
	            <div class="page-tabs-content">
	                <a href="javascript:;" class="active J_menuTab" data-id="/admin/index/index">首页</a>
	            </div>
	        </nav>
	        <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
	        </button>
	        <div class="btn-group roll-nav roll-right">
	            <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>
	
	            </button>
	            <ul role="menu" class="dropdown-menu dropdown-menu-right">
	                <li class="J_tabShowActive"><a>定位当前选项卡</a>
	                </li>
	                <li class="divider"></li>
	                <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
	                </li>
	                <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
	                </li>
	            </ul>
	        </div>
	        <a title="${contextPath}/sys/user/exit" onclick="exitLogin()" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
	    </div>
	    <div class="row J_mainContent" id="content-main">
	        <iframe id="ldh_content_iframe" class="J_iframe" name="iframe0" width="100%" height="100%" src="${contextPath}/index.jsp" data-id="/admin/index/index" seamless></iframe>
	    </div>
	    <div class="footer">
	        <div class="pull-right">&copy; 2017 <a href="http://www.zi-han.net/" target="_blank">hs</a>
	        </div>
	    </div>
	</div>
	
	
	
	
	
	<div id="right-sidebar">
    <div class="sidebar-container">

        <ul class="nav nav-tabs navs-3">

            <li class="active">
                <a data-toggle="tab" href="#tab-1">
                    <i class="fa fa-gear"></i> 主题
                </a>
            </li>
            <li class=""><a data-toggle="tab" href="#tab-2">
                通知
            </a>
            </li>
            <li><a data-toggle="tab" href="#tab-3">
                项目进度
            </a>
            </li>
        </ul>

        <div class="tab-content">
            <div id="tab-1" class="tab-pane active">
                <div class="sidebar-title">
                    <h3> <i class="fa fa-comments-o"></i> 主题设置</h3>
                    <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                </div>
                <div class="skin-setttings">
                    <div class="title">主题设置</div>
                    <div class="setings-item">
                        <span>收起左侧菜单</span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                <label class="onoffswitch-label" for="collapsemenu">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                        <span>固定顶部</span>

                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                <label class="onoffswitch-label" for="fixednavbar">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                                <span>
                        固定宽度
                    </span>

                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                <label class="onoffswitch-label" for="boxedlayout">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="title">皮肤选择</div>
                    <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             默认皮肤
                         </a>
                    </span>
                    </div>
                    <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            蓝色主题
                        </a>
                    </span>
                    </div>
                    <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            黄色/紫色主题
                        </a>
                    </span>
                    </div>
                </div>
            </div>
            <div id="tab-2" class="tab-pane">

                <div class="sidebar-title">
                    <h3> <i class="fa fa-comments-o"></i> 最新通知</h3>
                    <small><i class="fa fa-tim"></i> 您当前有10条未读信息</small>
                </div>

                <div>

                    <div class="sidebar-message">
                        <a href="#">
                            <%-- <div class="pull-left text-center">
                                <img alt="image" class="img-circle message-avatar" src="${contextPath}/static/Hplus/img/a1.jpg">

                                <div class="m-t-xs">
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                </div>
                            </div>
                            <div class="media-body">

                                据天津日报报道：瑞海公司董事长于学伟，副董事长董社轩等10人在13日上午已被控制。
                                <br>
                                <small class="text-muted">今天 4:21</small>
                            </div> --%>
                        </a>
                    </div>
                    <div class="sidebar-message">
                        <a href="#">
                            <<%-- div class="pull-left text-center">
                                <img alt="image" class="img-circle message-avatar" src="${contextPath}/static/Hplus/img/a2.jpg">
                            </div>
                            <div class="media-body">
                                HCY48之音乐大魔王会员专属皮肤已上线，快来一键换装拥有他，宣告你对华晨宇的爱吧！
                                <br>
                                <small class="text-muted">昨天 2:45</small>
                            </div> --%>
                        </a>
                    </div>
                    <div class="sidebar-message">
                        <a href="#">
                            <%-- <div class="pull-left text-center">
                                <img alt="image" class="img-circle message-avatar" src="${contextPath}/static/Hplus/img/a3.jpg">

                                <div class="m-t-xs">
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                </div>
                            </div>
                            <div class="media-body">
                                写的好！与您分享
                                <br>
                                <small class="text-muted">昨天 1:10</small>
                            </div> --%>
                        </a>
                    </div>
                    <div class="sidebar-message">
                        <a href="#">
                            <%-- <div class="pull-left text-center">
                                <img alt="image" class="img-circle message-avatar" src="${contextPath}/static/Hplus/img/a4.jpg">
                            </div>

                            <div class="media-body">
                                国外极限小子的炼成！这还是亲生的吗！！
                                <br>
                                <small class="text-muted">昨天 8:37</small>
                            </div> --%>
                        </a>
                    </div>
                    <div class="sidebar-message">
                        <a href="#">
                            <%-- <div class="pull-left text-center">
                                <img alt="image" class="img-circle message-avatar" src="${contextPath}/static/Hplus/img/a8.jpg">
                            </div>
                            <div class="media-body">

                                一只流浪狗被收留后，为了减轻主人的负担，坚持自己觅食，甚至......有些东西，可能她比我们更懂。
                                <br>
                                <small class="text-muted">今天 4:21</small>
                            </div> --%>
                        </a>
                    </div>
                    <div class="sidebar-message">
                        <a href="#">
                            <%-- <div class="pull-left text-center">
                                <img alt="image" class="img-circle message-avatar" src="${contextPath}/static/Hplus/img/a7.jpg">
                            </div>
                            <div class="media-body">
                                这哥们的新视频又来了，创意杠杠滴，帅炸了！
                                <br>
                                <small class="text-muted">昨天 2:45</small>
                            </div> --%>
                        </a>
                    </div>
                    <div class="sidebar-message">
                        <a href="#">
                            <%-- <div class="pull-left text-center">
                                <img alt="image" class="img-circle message-avatar" src="${contextPath}/static/Hplus/img/a3.jpg">

                                <div class="m-t-xs">
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                </div>
                            </div>
                            <div class="media-body">
                                最近在补追此剧，特别喜欢这段表白。
                                <br>
                                <small class="text-muted">昨天 1:10</small>
                            </div> --%>
                        </a>
                    </div>
                    <div class="sidebar-message">
                        <a href="#">
                            <%-- <div class="pull-left text-center">
                                <img alt="image" class="img-circle message-avatar" src="${contextPath}/static/Hplus/img/a4.jpg">
                            </div>
                            <div class="media-body">
                                我发起了一个投票 【你认为下午大盘会翻红吗？】
                                <br>
                                <small class="text-muted">星期一 8:37</small>
                            </div> --%>
                        </a>
                    </div>
                </div>

            </div>
            <div id="tab-3" class="tab-pane">

                <div class="sidebar-title">
                    <h3> <i class="fa fa-cube"></i> 最新任务</h3>
                    <small><i class="fa fa-tim"></i> 您当前有14个任务，10个已完成</small>
                </div>

                <ul class="sidebar-list">
                    <li>
                        <a href="#">
                            <!-- <div class="small pull-right m-t-xs">9小时以后</div>
                            <h4>市场调研</h4> 按要求接收教材；

                            <div class="small">已完成： 22%</div>
                            <div class="progress progress-mini">
                                <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                            </div>
                            <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div> -->
                        </a>
                    </li>
                    <li>
                        <a href="#">
                           <!--  <div class="small pull-right m-t-xs">9小时以后</div>
                            <h4>可行性报告研究报上级批准 </h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                            <div class="small">已完成： 48%</div>
                            <div class="progress progress-mini">
                                <div style="width: 48%;" class="progress-bar"></div>
                            </div> -->
                        </a>
                    </li>
                    <li>
                        <a href="#">
                           <!--  <div class="small pull-right m-t-xs">9小时以后</div>
                            <h4>立项阶段</h4> 东风商用车公司 采购综合综合查询分析系统项目进度阶段性报告武汉斯迪克科技有限公司

                            <div class="small">已完成： 14%</div>
                            <div class="progress progress-mini">
                                <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                            </div> -->
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="label label-primary pull-right">NEW</span>
                            <!-- <h4>设计阶段</h4>
                            <div class="small pull-right m-t-xs">9小时以后</div>
                            项目进度报告(Project Progress Report)
                            <div class="small">已完成： 22%</div>
                            <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div> -->
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <!-- <div class="small pull-right m-t-xs">9小时以后</div>
                            <h4>拆迁阶段</h4> 科研项目研究进展报告 项目编号: 项目名称: 项目负责人:

                            <div class="small">已完成： 22%</div>
                            <div class="progress progress-mini">
                                <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                            </div>
                            <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div> -->
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <!-- <div class="small pull-right m-t-xs">9小时以后</div>
                            <h4>建设阶段 </h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                            <div class="small">已完成： 48%</div>
                            <div class="progress progress-mini">
                                <div style="width: 48%;" class="progress-bar"></div>
                            </div> -->
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <!-- <div class="small pull-right m-t-xs">9小时以后</div>
                            <h4>获证开盘</h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                            <div class="small">已完成： 14%</div>
                            <div class="progress progress-mini">
                                <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                            </div> -->
                        </a>
                    </li>

                </ul>

            </div>
        </div>

    </div>
</div>

	
	<script src="${contextPath}/static/Hplus/js/jquery.min.js?v=2.1.4"></script>
	<script src="${contextPath}/static/Hplus/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="${contextPath}/static/Hplus/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="${contextPath}/static/Hplus/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="${contextPath}/static/Hplus/js/plugins/layer/layer.min.js"></script>
	
	<!-- 自定义js -->
	<script src="${contextPath}/static/Hplus/js/hplus.js?v=4.1.0"></script>
	<script type="text/javascript" src="${contextPath}/static/Hplus/js/contabs.js"></script>
	
	<!-- 第三方插件 -->
	<script src="${contextPath}/static/Hplus/js/plugins/pace/pace.min.js"></script>
</div>
</body>
</html>