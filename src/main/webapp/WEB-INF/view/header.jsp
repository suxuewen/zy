<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sxw" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/javascript; charset=gb2312" />
<title>视频列表</title>

<link href="${pageContext.request.contextPath}/css/jquery-confirm.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-confirm.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<nav class="navbar navbar-inverse">

			<ul class="nav navbar-nav">

				<li style="font-size: 30px;"><a href="#">视频管理系统</a></li>
				<li <c:if test='${param.fromJsp=="video"}'> class="active"</c:if>><a href="<c:url value="/admin/video/videolist.action"></c:url>">视频管理</a></li>
				<li <c:if test='${param.fromJsp=="speaker"}'> class="active"</c:if>><a href="<c:url value="/admin/speaker/speakerlist.action"></c:url>">主讲人管理</a></li>
				<li <c:if test='${param.fromJsp=="course"}'> class="active"</c:if>><a href="<c:url value="/admin/course/courselist.action"></c:url>">课程管理</a></li>
				<li <c:if test='${param.fromJsp=="charts"}'> class="active"</c:if>><a href="<c:url value="/admin/charts/chartslist.action"></c:url>">统计分析</a></li>
			</ul>
                  <p class="navbar-text navbar-right" style="margin-left: 450px;" >
					${admin.loginName}<a href="#" class="glyphicon glyphicon-share">退出</a>
				</p>
		</nav>
	</div>




</body>
</html>